package com.gg.spora.quiz.ui

import androidx.lifecycle.ViewModel
import com.gg.spora.core.utils.SporaConstant.MAX_QUESTIONS
import com.gg.spora.quiz.domain.GetRandomQuestionFromTypeUseCase
import com.gg.spora.quiz.domain.model.Question
import com.gg.spora.quiz.domain.model.QuestionType
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

    init {
        getRandomQuestions()
        getCurrentQuestion()
    }

    private fun getCurrentQuestion() {
        _currentQuestion.value = _questions.value[_currentQuestionIndex.value]
    }

    private fun getRandomQuestions() {
        _questions.value = getRandomQuestionFromTypeUseCase(MAX_QUESTIONS, QuestionType.RECYCLING)
    }

    fun isAnswerCorrect(answerId: String) {
        _isCorrect.value  = _questions.value[_currentQuestionIndex.value].answer.id == answerId
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
    }

    fun nextQuestion() {
        _currentQuestionIndex.value++
        _currentQuestion.value = _questions.value[_currentQuestionIndex.value]
        _isCorrect.value = null
    }

}