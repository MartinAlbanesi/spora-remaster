package com.gg.spora.miniGames.domain

import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.model.Question
import javax.inject.Inject

class GetRandomQuestionFromTypeUseCase @Inject constructor(
    private val quizLocalRepository: IQuizLocalRepository
) {
    operator fun invoke(count : Int, typeQuestion: TypeQuestion, typeGame: TypeGame): List<Question> {
        val randomQuestions = quizLocalRepository
            .getRandomQuestions(count,typeQuestion,typeGame)
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