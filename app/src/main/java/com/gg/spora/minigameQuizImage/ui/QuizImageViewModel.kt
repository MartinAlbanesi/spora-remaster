package com.gg.spora.minigameQuizImage.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.gg.spora.R
import com.gg.spora.minigameQuizImage.domain.model.GetRamdonQuestionImage
import com.gg.spora.minigameQuizImage.domain.model.model.ImageQuestionType
import com.gg.spora.minigameQuizImage.domain.model.model.QuestionImage
import com.gg.spora.quiz.domain.model.QuestionType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

const val MAX_QUESTIONS = 5

@HiltViewModel
class QuizImageViewModel @Inject constructor(
    private val getRamdonQuestionImage: GetRamdonQuestionImage
) : ViewModel(){

     private val _questions = MutableStateFlow<List<QuestionImage>>(emptyList())

    private val _currentQuestionIndex = MutableStateFlow(0)

    private val _currentQuestion = MutableStateFlow<QuestionImage?>(null)
    val currentQuestion = _currentQuestion.asStateFlow()

    private val _currentImageResId = MutableStateFlow<Int>(R.drawable.recurso_viento)
    val currentImageResId: StateFlow<Int> = _currentImageResId.asStateFlow()

    private val _isCorrect = MutableStateFlow<Boolean?>(null)
    val isCorrect = _isCorrect.asStateFlow()

    init {
        getRandomQuestions()
        getCurrentQuestion()
        _currentImageResId.value = _currentQuestion.value?.imageResId ?: R.drawable.recurso_viento
    }
    val questionImageResId = currentQuestion.value?.imageResId ?: R.drawable.recurso_viento

    private fun getCurrentQuestion() {
        _currentQuestion.value = _questions.value[_currentQuestionIndex.value]
    }

    private fun getRandomQuestions() {
        _questions.value = getRamdonQuestionImage(MAX_QUESTIONS, ImageQuestionType.RECYCLINGIMAGE)
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
        _currentImageResId.value = _currentQuestion.value?.imageResId ?: R.drawable.recurso_viento
        _isCorrect.value = null
    }

}

