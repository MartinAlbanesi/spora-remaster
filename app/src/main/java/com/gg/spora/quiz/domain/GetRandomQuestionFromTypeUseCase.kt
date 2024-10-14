package com.gg.spora.quiz.domain

import com.gg.spora.core.utils.enums.GameType
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.quiz.domain.model.Question
import javax.inject.Inject

class GetRandomQuestionFromTypeUseCase @Inject constructor(
    private val quizLocalRepository: IQuizLocalRepository
) {
    operator fun invoke(count : Int, type: GameType, typeQuestion: TypeQuestion): List<Question> {

        val randomQuestions = quizLocalRepository
            .getRandomQuestions(count,type,typeQuestion)
            .map { question ->
                val answer = quizLocalRepository.getAnswerById(question.answerId)
                val newQuestion = question.copy(
                    answers = (question.answers + answer).shuffled()
                )
                newQuestion
            }
        return randomQuestions
    }
}