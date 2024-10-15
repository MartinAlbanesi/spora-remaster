package com.gg.spora.miniGames.ui

import androidx.lifecycle.ViewModel
import com.gg.spora.core.utils.SporaConstant.MAX_LIVES
import com.gg.spora.core.utils.SporaConstant.MAX_QUESTIONS
import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.GetRandomQuestionFromTypeUseCase
import com.gg.spora.miniGames.domain.model.Question
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val getRandomQuestionFromTypeUseCase: GetRandomQuestionFromTypeUseCase
) : ViewModel(){

    private val _questions = MutableStateFlow<List<Question>>(emptyList())
//    val questions = _questions.asStateFlow()

    private val _currentQuestionIndex = MutableStateFlow(0)
//    val currentQuestionIndex = _currentQuestionIndex.asStateFlow()

    private val _currentQuestion = MutableStateFlow<Question?>(null)
    val currentQuestion = _currentQuestion.asStateFlow()

    private val _isCorrect = MutableStateFlow<Boolean?>(null)
    val isCorrect = _isCorrect.asStateFlow()

    private val _isFinished = MutableStateFlow(false)
    val isFinished = _isFinished.asStateFlow()

    private val _lives = MutableStateFlow(MAX_LIVES)
    val lives = _lives.asStateFlow()

    private val _counterQuestion = MutableStateFlow(0)
    val counterQuestion = _counterQuestion.asStateFlow()

    init {
        getRandomQuestions()
        getCurrentQuestion()
    }

    private fun getCurrentQuestion() {
        _currentQuestion.value = _questions.value[_currentQuestionIndex.value]
    }

    private fun getRandomQuestions() {
        _questions.value = getRandomQuestionFromTypeUseCase(MAX_QUESTIONS, TypeGame.QUIZ, TypeQuestion.MARTIN)
    }

    fun isAnswerCorrect(answerId: String) {
        _isCorrect.value  = _questions.value[_currentQuestionIndex.value].answerId == answerId
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
                    it
                }
            }
        )

        if(_isCorrect.value == false) {
            _lives.value--
        }
    }

    fun nextQuestion() {
        if(_currentQuestionIndex.value == MAX_QUESTIONS - 1 || _lives.value <= 0) {
            _isFinished.value = true
            return
        }
        _currentQuestionIndex.value++
        _counterQuestion.value++
        _currentQuestion.value = _questions.value[_currentQuestionIndex.value]
        _isCorrect.value = null
    }

    fun resetGame() {
        _counterQuestion.value = 0
        _currentQuestionIndex.value = 0
        _lives.value = MAX_LIVES
        _isFinished.value = false
        _isCorrect.value = null
        getRandomQuestions()
        getCurrentQuestion()
    }

}