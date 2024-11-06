package com.gg.spora.miniGames.domain

import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.model.Question

interface IQuizNetworkRepository {

    fun getQuestions(count: Int, typeQuestion: List<TypeQuestion>, typeGame: TypeGame): List<Question>

    fun getQuestionById(id: String): Question?
}