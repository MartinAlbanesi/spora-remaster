package com.gg.spora.miniGames.data.network.models

import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.IQuizNetworkRepository
import com.gg.spora.miniGames.domain.model.Question
import javax.inject.Inject

class QuizNetworkRepository @Inject constructor(

) : IQuizNetworkRepository {
    override fun getQuestions(
        count: Int,
        typeQuestion: List<TypeQuestion>,
        typeGame: TypeGame
    ): List<Question> {
        TODO("Not yet implemented")
    }

    override fun getQuestionById(id: String): Question? {
        TODO("Not yet implemented")
    }
}