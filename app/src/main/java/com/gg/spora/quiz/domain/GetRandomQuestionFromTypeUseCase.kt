package com.gg.spora.quiz.domain

import com.gg.spora.quiz.domain.model.Question
import com.gg.spora.quiz.domain.model.QuestionType
import javax.inject.Inject

class GetRandomQuestionFromTypeUseCase @Inject constructor(
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
}