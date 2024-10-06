package com.gg.spora.minigameQuizImage.domain.model

import com.gg.spora.minigameQuizImage.domain.model.model.ImageQuestionType
import com.gg.spora.minigameQuizImage.domain.model.model.QuestionImage
import javax.inject.Inject

class GetRamdonQuestionImage  @Inject constructor(
    private val quizImageLocalRepository: IQuizImageLocalRepository
){
    operator fun invoke(count: Int, type: ImageQuestionType): List<QuestionImage> {
        val randomQuestions = quizImageLocalRepository
            .getRandomQuestionsImage(count, type)
            .map { question ->
                val newQuestion = question.copy(
                    answers = (question.answers + question.answer).shuffled()
                )
                newQuestion
            }
        return randomQuestions
    }
}


/*class GetRandomQuestionFromTypeUseCase @Inject constructor(
    private val quizLocalRepository: IQuizLocalRepository
) {
    operator fun invoke(count : Int, type: QuestionType): List<Question> {

        val randomQuestions = quizLocalRepository
            .getRandomQuestions(count,type)
            .map { question ->
                val newQuestion = question.copy(
                    answers = (question.answers + question.answer).shuffled()
                )
                newQuestion
            }
        return randomQuestions
    }
}*/