package com.gg.spora.minigameQuizImage.ui

import androidx.lifecycle.ViewModel
import com.gg.spora.R
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.SporaConstant.MAX_LIVES
import com.gg.spora.core.utils.SporaConstant.MAX_QUESTIONS
import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.GetRandomQuestionFromTypeUseCase
import com.gg.spora.miniGames.domain.model.Question
import com.gg.spora.minigameQuizImage.domain.model.GetRamdonQuestionImage
import com.gg.spora.minigameQuizImage.domain.model.model.ImageQuestionType
import com.gg.spora.minigameQuizImage.domain.model.model.QuestionImage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class QuizImageViewModel @Inject constructor(
    private val getRandomQuestionFromTypeUseCase: GetRandomQuestionFromTypeUseCase
) : ViewModel() {

    private val _questions = MutableStateFlow<List<Question>>(emptyList())

    private val _currentQuestionIndex = MutableStateFlow(0)

    private val _currentQuestion = MutableStateFlow<Question?>(null)
    val currentQuestion = _currentQuestion.asStateFlow()

    private val _currentImageResId = MutableStateFlow<Int>(R.drawable.recurso_viento)
    val currentImageResId: StateFlow<Int> = _currentImageResId.asStateFlow()

    private val _isCorrect = MutableStateFlow<Boolean?>(null)
    val isCorrect = _isCorrect.asStateFlow()

    private val _isFinished = MutableStateFlow(false)
    val isFinished = _isFinished.asStateFlow()

    private val _lives = MutableStateFlow(MAX_LIVES)
    val lives = _lives.asStateFlow()

    private val _counterQuestion = MutableStateFlow(0)
    val counterQuestion = _counterQuestion.asStateFlow()

    private val _areOptionsEnabled = MutableStateFlow(true) //BORRAR SI NO FUNCIONA
    val areOptionsEnabled: StateFlow<Boolean> = _areOptionsEnabled.asStateFlow()//BORRAR SI NO FUNCIONA

    init {
        getRandomQuestions()
        getCurrentQuestion()
        _currentImageResId.value = _currentQuestion.value?.image ?: R.drawable.recurso_viento
    }

    private fun getCurrentQuestion() {
        _currentQuestion.value = _questions.value[_currentQuestionIndex.value]
    }

    private fun getRandomQuestions() {
        _questions.value = getRandomQuestionFromTypeUseCase(
            count = MAX_QUESTIONS,
            typeQuestion = TypeQuestion.RECYCLE,
            typeGame = TypeGame.QUIZ_IMAGE
        )
    }

    fun isAnswerCorrect(answerId: String) {
        _isCorrect.value = _questions.value[_currentQuestionIndex.value].answerId == answerId
        _areOptionsEnabled.value = false
        _currentQuestion.value = _currentQuestion.value?.copy(
            answers = _currentQuestion.value!!.answers.map {
                if (it.id == answerId) {
                    it.copy(
                        isCorrect = _isCorrect.value,
                    )
                } else {
                    it
                }
            }
        )

        if(_isCorrect.value == false) {
            _lives.value--
        }
    }

    fun nextQuestion() {
        if (_currentQuestionIndex.value == SporaConstant.MAX_QUESTIONS - 1 || _lives.value <= 0) {
            _isFinished.value = true
            return
        }
        _currentQuestionIndex.value++
        _counterQuestion.value++
        _currentQuestion.value = _questions.value[_currentQuestionIndex.value]
        _currentImageResId.value = _currentQuestion.value?.image ?: R.drawable.recurso_viento
        _isCorrect.value = null
        _areOptionsEnabled.value = true //BORRAR SI NO FUNCIONA
    }

    fun resetGame() {
        _counterQuestion.value = 0
        _currentQuestionIndex.value = 0
        _lives.value = MAX_LIVES
        _isFinished.value = false
        _isCorrect.value = null
        _areOptionsEnabled.value = true
        getRandomQuestions()
        getCurrentQuestion()
        _currentImageResId.value = _currentQuestion.value?.image ?: R.drawable.recurso_viento

    }

}

