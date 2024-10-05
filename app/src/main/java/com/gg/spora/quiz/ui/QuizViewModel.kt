package com.gg.spora.quiz.ui

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.gg.spora.quiz.domain.GetRandomQuestionFromTypeUseCase
import com.gg.spora.quiz.domain.model.Question
import com.gg.spora.quiz.domain.model.QuestionType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

const val MAX_QUESTIONS = 10

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
        val isCorrect  = _questions.value[_currentQuestionIndex.value].answer.id == answerId
        _currentQuestion.value = _currentQuestion.value?.copy(
            answers = _currentQuestion.value!!.answers.map {
                if (it.id == answerId) {
                    it.copy(
                        isCorrect = isCorrect,
                        textColor = Color.White,
                        backgroundColor = if (isCorrect) Color(0xff538c21) else Color(0xffb3261e)
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
    }

}