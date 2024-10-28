package com.gg.spora.miniGames.data.local

import android.content.Context
import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.IQuizLocalRepository
import com.gg.spora.miniGames.domain.mappers.toAnswer
import com.gg.spora.miniGames.domain.mappers.toQuestion
import com.gg.spora.miniGames.domain.model.Answer
import com.gg.spora.miniGames.domain.model.Question
import javax.inject.Inject

class QuizLocalRepository @Inject constructor(
    private val context: Context,
    private val quizLocalService: QuizLocalService
) : IQuizLocalRepository {

    override fun getRandomQuestions(
        count: Int,
        typeQuestion: List<TypeQuestion>,
        typeGame: TypeGame
    ): List<Question> {
        val questionsLocal = quizLocalService.getLocalQuestions()
            .map { it.toQuestion(context) }
            .filter { it.typeQuestion.intersect(typeQuestion.toSet()).isNotEmpty() }
            .filter { it.typeGame == typeGame }
            .shuffled()
            .take(count)
        return questionsLocal
    }

    override fun getQuestionById(id: String): Question? {
        val questionLocal = quizLocalService.getLocalQuestions().find { it.id == id }
        return questionLocal?.toQuestion(context)
    }

    override fun getRandomAnswers(count: Int, typeQuestion: List<TypeQuestion>, typeGame: TypeGame): List<Answer> {
        val answersLocal = quizLocalService.getLocalAnswers()
            .map { it.toAnswer() }
            .filter { it.typeQuestion.intersect(typeQuestion.toSet()).isNotEmpty() }
            .filter { it.typeGame == typeGame }
            .shuffled()
            .take(count)
        return answersLocal
    }

    override fun getAnswerById(id: String): Answer? {
        val answerLocal = quizLocalService.getLocalAnswers().find { it.id == id }
        return answerLocal?.toAnswer()
    }
}