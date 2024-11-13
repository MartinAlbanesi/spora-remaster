package com.gg.spora.miniGames.ui

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.gg.spora.R
import com.gg.spora.core.graph.NavigationRoutes
import com.gg.spora.core.utils.SporaConstant.MAX_LIVES
import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.core.utils.functions.getRewardsStarState
import com.gg.spora.core.utils.functions.getStageTypeByName
import com.gg.spora.core.utils.functions.getTotalOxygenFromStars
import com.gg.spora.miniGames.domain.GetRandomQuestionFromTypeUseCase
import com.gg.spora.miniGames.domain.model.Question
import com.gg.spora.user.domain.UpdateUserLevelsAndOxygenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val getRandomQuestionFromTypeUseCase: GetRandomQuestionFromTypeUseCase,
//    private val updateLevelStateUseCase: UpdateLevelStateUseCase,
    private val updateUserLevelsAndOxygenUseCase: UpdateUserLevelsAndOxygenUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val quizRoute = savedStateHandle.toRoute<NavigationRoutes.QuizGame>()

    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions = _questions.asStateFlow()

//    private val _currentQuestionIndex = MutableStateFlow(0)
//    val currentQuestionIndex = _currentQuestionIndex.asStateFlow()

    private val _currentQuestion = MutableStateFlow<Question?>(null)
    val currentQuestion = _currentQuestion.asStateFlow()

    private val _isCorrect = MutableStateFlow<Boolean?>(null)
    val isCorrect = _isCorrect.asStateFlow()

    private val _isFinished = MutableStateFlow(false)
    val isFinished = _isFinished.asStateFlow()

    private val _lives = MutableStateFlow(MAX_LIVES)
    val lives = _lives.asStateFlow()

    private val _livesLost = MutableStateFlow(0)
    val livesLost = _livesLost.asStateFlow()

    private val _counterQuestion = MutableStateFlow(0)
    val counterQuestion = _counterQuestion.asStateFlow()

    private val _currentImageResId = MutableStateFlow(R.drawable.wind_turbine)
    val currentImageResId = _currentImageResId.asStateFlow()

    private val _relationsItems = MutableStateFlow<List<String>>(emptyList())
    val relationsItems = _relationsItems.asStateFlow()

    private val _showChampyHelp = MutableStateFlow(false)
    val showChampyHelp = _showChampyHelp.asStateFlow()

    init {
        getRandomQuestions()
        getCurrentQuestion()
        _currentImageResId.value = _currentQuestion.value?.image ?: R.drawable.wind_turbine
    }

    private fun getCurrentQuestion() {
        _currentQuestion.value = _questions.value[_counterQuestion.value]
    }

    private fun getRandomQuestions() {

        val quizGame = getRandomQuestionFromTypeUseCase(
            count = quizRoute.quizCount.toInt(),
            typeQuestion = listOf(TypeQuestion.MARTIN),
            typeGame = TypeGame.QUIZ
        )

        val imageGame = getRandomQuestionFromTypeUseCase(
            count = quizRoute.imageCount.toInt(),
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE
        )

        val relationsGame = getRandomQuestionFromTypeUseCase(
            count = quizRoute.relationsCount.toInt(),
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        )

        _questions.value = (quizGame + imageGame + relationsGame).shuffled()
    }

    fun isAnswerCorrect(answerId: String) {
        _isCorrect.value = _questions.value[_counterQuestion.value].answerId == answerId
        _currentQuestion.value = _currentQuestion.value?.copy(
            answers = _currentQuestion.value!!.answers.map {
                // si la respuesta es la correcta
                if (it.id == answerId) {
                    it.copy(
                        isCorrect = _isCorrect.value,
                    )
                }
                // si la respuesta es incorrecta
                else {
                    it.copy(
                        isCorrect = if (it.id == _currentQuestion.value!!.answerId) true else null,
                    )
                }
            }
        )

        if (_isCorrect.value == false) {
            _lives.value--
            _livesLost.value++
        }
    }

    fun onSelectedItem(answerId: String) {

        if (_relationsItems.value.contains(answerId)) {
            _relationsItems.value -= answerId
            return
        }

        if (_relationsItems.value.size < 3) {
            _relationsItems.value += answerId
        }
    }

    fun relationsAnswerSelected() {
        val correctAnswer = _currentQuestion.value!!.answerId.split(",").map { it.toInt() }.toSet()
        val selectedAnswers = _relationsItems.value.map { it.toInt() }.toSet()

        if (correctAnswer == selectedAnswers) {
            _isCorrect.value = true
        } else {
            _isCorrect.value = false
            _lives.value--
            _livesLost.value++
        }

        _relationsItems.value = emptyList()

        _currentQuestion.value = _currentQuestion.value?.copy(
            answers = _currentQuestion.value!!
                .answers
                .map {
                    if (selectedAnswers.contains(it.id.toInt())) {
                        it.copy(
                            isCorrect = correctAnswer.contains(it.id.toInt())
                        )
                    } else {
                        it.copy(
                            isCorrect = if (correctAnswer.contains(it.id.toInt())) true else null
                        )
                    }
                }
        )
    }

    fun nextQuestion() {
        if (_counterQuestion.value == _questions.value.size - 1) {

            finishGame()

            return
        }
        if (_lives.value <= 0) {
            _isFinished.value = true
            return
        }
        _showChampyHelp.value = false
        _counterQuestion.value++
        _currentQuestion.value = _questions.value[_counterQuestion.value]
        _currentImageResId.value = _currentQuestion.value?.image ?: R.drawable.wind_turbine
        _isCorrect.value = null
    }

    fun resetGame() {
        _counterQuestion.value = 0
        _lives.value = MAX_LIVES
        _livesLost.value = 0
        _isFinished.value = false
        _isCorrect.value = null
        getRandomQuestions()
        getCurrentQuestion()
        _currentImageResId.value = _currentQuestion.value?.image ?: R.drawable.wind_turbine
    }

    private fun finishGame() {
        _isFinished.value = true

        viewModelScope.launch {

            val currentStarState = getRewardsStarState(livesLost = _livesLost.value)
            val currentLevelOxygenRewards = quizRoute.oxygenRewards

            updateUserLevelsAndOxygenUseCase(
                levelId = quizRoute.levelId,
                starState = currentStarState,
                stageType = getStageTypeByName(quizRoute.stageType),
                oxygenRewards = currentLevelOxygenRewards
            )
        }
    }

    fun onShowChampyHelp() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(3000)
            _showChampyHelp.value = true
        }
    }

}