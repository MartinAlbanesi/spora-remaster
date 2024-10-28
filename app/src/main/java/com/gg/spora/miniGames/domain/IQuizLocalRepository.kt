package com.gg.spora.miniGames.domain

import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.model.Answer
import com.gg.spora.miniGames.domain.model.Question

/**
 * Local repository for quiz questions
 */
interface IQuizLocalRepository {

    fun getRandomQuestions(count: Int, typeQuestion: List<TypeQuestion>, typeGame: TypeGame): List<Question>

    fun getQuestionById(id: String): Question?

    fun getRandomAnswers(count: Int, typeQuestion: List<TypeQuestion>, typeGame: TypeGame): List<Answer>

    fun getAnswerById(id: String): Answer?

}