package com.gg.spora.miniGames.ui

import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.gg.spora.core.fake.FakeQuizModels
import com.gg.spora.core.graph.NavigationRoutes
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.SporaConstant.MAX_LIVES
import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.core.utils.functions.getRewardsStarState
import com.gg.spora.core.utils.functions.getStageTypeByName
import com.gg.spora.miniGames.domain.GetRandomQuestionFromTypeUseCase
import com.gg.spora.miniGames.domain.model.Question
import com.gg.spora.miniGames.ui.models.ChampyHelping
import com.gg.spora.missions.domain.UpdateMissionByIdUseCase
import com.gg.spora.missions.domain.enums.MissionType
import com.gg.spora.missions.domain.models.Mission
import com.gg.spora.user.domain.UpdateUserLevelsAndOxygenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val getRandomQuestionFromTypeUseCase: GetRandomQuestionFromTypeUseCase,
    private val updateUserLevelsAndOxygenUseCase: UpdateUserLevelsAndOxygenUseCase,
    private val updateMissionByIdUseCase: UpdateMissionByIdUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val quizRoute = savedStateHandle.toRoute<NavigationRoutes.QuizGame>()

    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions = _questions.asStateFlow()

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

    private val _currentImageResId = MutableStateFlow<String?>(null)
    val currentImageResId = _currentImageResId.asStateFlow()

    private val _relationsItems = MutableStateFlow<List<String>>(emptyList())
    val relationsItems = _relationsItems.asStateFlow()

    private val _showChampyHelp = MutableStateFlow(false)
    val showChampyHelp = _showChampyHelp.asStateFlow()

    private val _champyHelpingText = MutableStateFlow<ChampyHelping?>(null)
    val champyHelpingText = _champyHelpingText.asStateFlow()

    private val _currentTotalRewards = MutableStateFlow(0)
    val currentTotalRewards = _currentTotalRewards.asStateFlow()

    private val _currentRewards = MutableStateFlow(listOf(0, 0, 0))
    val currentRewards = _currentRewards.asStateFlow()

    private val _missionCompleted = MutableStateFlow<Mission?>(null)
    val missionCompleted: StateFlow<Mission?> = _missionCompleted

    private val _isRewardsLoading = MutableStateFlow(false)
    val isRewardsLoading: StateFlow<Boolean> = _isRewardsLoading

    init {
        getRandomQuestions()
        getCurrentQuestion()
        _currentImageResId.value =
            _currentQuestion.value?.image ?: "android.resource://com.gg.spora/drawable/wind_turbine"

    }

    private fun getCurrentQuestion() {
        _currentQuestion.value = _questions.value[_counterQuestion.value]
    }

    private fun getRandomQuestions() {

        val quizGame = getRandomQuestionFromTypeUseCase(
            count = quizRoute.quizCount,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ
        )

        val imageGame = getRandomQuestionFromTypeUseCase(
            count = quizRoute.imageCount,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.QUIZ_IMAGE
        )

        val relationsGame = getRandomQuestionFromTypeUseCase(
            count = quizRoute.relationsCount,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS
        )

        _questions.value = (quizGame + imageGame + relationsGame).shuffled()
    }

    fun isAnswerCorrect(answerId: String) {

        _currentQuestion.value = _currentQuestion.value?.copy(
            answers = _currentQuestion.value!!.answers.map {
                // si la respuesta es la Correcta
                if (it.id == answerId) {


                    it.copy(
                        isCorrect = true
                    )
                }
                // si la respuesta es Incorrecta
                else {
                    it.copy(
                        isCorrect = null,
                    )
                }
            }
        )
    }

    fun onConfirmAnswer(answerId: String) {
        val correctAnswer = _currentQuestion.value!!.correctAnswer
        _isCorrect.value = correctAnswer == answerId

        _showChampyHelp.value = true

        if (_isCorrect.value == false) {

            _champyHelpingText.value = ChampyHelping(
                text = "La respuesta era: ${_currentQuestion.value!!.answers.first { it.id == correctAnswer }.answer}",
                fontSize = 20,
                textAlign = TextAlign.Center
            )



            _lives.value--
            _livesLost.value++
        } else {
            _champyHelpingText.value = ChampyHelping(
                text = SporaConstant.CHAMPY_CONGRATULATING_YOU_LIST.random(),
                fontSize = 20,
                textAlign = TextAlign.Center
            )
        }
    }

    fun relationsAnswerSelected() {
        val correctAnswer =
            _currentQuestion.value!!.correctAnswer.split(",").map { it.toInt() }.toSet()
        val selectedAnswers = _relationsItems.value.map { it.toInt() }.toSet()

        _showChampyHelp.value = true

        val correctsAnswers = FakeQuizModels.newFakeAnswers
            .filter {
                it.id.toInt() in correctAnswer
            }.joinToString(", ") {
                it.answer
            }

        if (correctAnswer == selectedAnswers) {
            _champyHelpingText.value = ChampyHelping(
                text = SporaConstant.CHAMPY_CONGRATULATING_YOU_LIST.random(),
                fontSize = 20,
                textAlign = TextAlign.Center
            )

            _isCorrect.value = true
        } else {

            _champyHelpingText.value = ChampyHelping(
                text = "La respuestas eran: $correctsAnswers",
                fontSize = 20,
                textAlign = TextAlign.Center
            )

            _isCorrect.value = false
            _lives.value--
            _livesLost.value++
        }

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

    fun onSelectedItem(answerId: String) {

        if (_relationsItems.value.contains(answerId)) {
            _relationsItems.value -= answerId
            return
        }

        if (_relationsItems.value.size < 3) {
            _relationsItems.value += answerId
        }
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
        _champyHelpingText.value = null
        _counterQuestion.value++
        _currentQuestion.value = _questions.value[_counterQuestion.value]
        _currentImageResId.value =
            _currentQuestion.value?.image ?: "android.resource://com.gg.spora/drawable/wind_turbine"
        _isCorrect.value = null
        _relationsItems.value = emptyList()
    }

    fun resetGame() {

        _showChampyHelp.value = false
        _champyHelpingText.value = null

        _counterQuestion.value = 0
        _lives.value = MAX_LIVES
        _livesLost.value = 0
        _isFinished.value = false
        _isCorrect.value = null
        getRandomQuestions()
        getCurrentQuestion()
        _currentImageResId.value =
            _currentQuestion.value?.image ?: "android.resource://com.gg.spora/drawable/wind_turbine"
        _relationsItems.value = emptyList()

    }

    private fun finishGame() {
        _isFinished.value = true
        _isRewardsLoading.value = true

        viewModelScope.launch {

            val currentStarState = getRewardsStarState(livesLost = _livesLost.value)
            val currentLevelOxygenRewards = quizRoute.oxygenRewards

            updateUserLevelsAndOxygenUseCase(
                levelId = quizRoute.levelId,
                starState = currentStarState,
                stageType = getStageTypeByName(quizRoute.stageType),
                oxygenRewards = currentLevelOxygenRewards
            ).apply {
                _currentTotalRewards.value = this.first
                _currentRewards.value = this.second
            }

            updateMission()
            _isRewardsLoading.value = false
        }
    }

    fun onShowChampyHelp() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(4000)
                currentQuestion.value?.champyHelping?.let{
                    _champyHelpingText.value = ChampyHelping(
                        text = it
                    )
                }

            _champyHelpingText.value?.let{
                _showChampyHelp.value = true
            }
        }
    }

    private fun updateMission() {
        viewModelScope.launch {
            _missionCompleted.value =
                updateMissionByIdUseCase(MissionType.MINI_GAME_MISSION.missionId)
        }
    }

}