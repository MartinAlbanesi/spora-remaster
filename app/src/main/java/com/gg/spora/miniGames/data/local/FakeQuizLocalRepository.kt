package com.gg.spora.miniGames.data.local

import com.gg.spora.core.fake.FakeQuizModels
import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.IQuizLocalRepository
import com.gg.spora.miniGames.domain.model.Answer
import com.gg.spora.miniGames.domain.model.Question
import javax.inject.Inject

class FakeQuizLocalRepository @Inject constructor(

) : IQuizLocalRepository {

    private val fakeModelsQuiz = FakeQuizModels.fakeQuestions

    override fun getRandomQuestions(
        count: Int,
        typeQuestion: TypeQuestion,
        typeGame: TypeGame,
    ): List<Question> {
        val randomQuestions = fakeModelsQuiz
            .filter { it.typeGame == typeGame && it.typeQuestion == typeQuestion }
            .shuffled()
            .take(count)
        return randomQuestions
    }

    override fun getQuestionById(id: String): Question {
        TODO("Not yet implemented")
    }

    override fun getRandomAnswers(count: Int, type: TypeGame): List<Answer> {
        TODO("Not yet implemented")
    }

    override fun getAnswerById(id: String): Answer {
        val randomAnswers = FakeQuizModels.fakeAnswers.first { it.id == id }
        return randomAnswers
    }
}