package com.gg.spora.minigameQuizImage.data.local

import com.gg.spora.core.fake.FakeQuizImageModels
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.model.Question
import com.gg.spora.minigameQuizImage.domain.model.IQuizImageLocalRepository
import com.gg.spora.minigameQuizImage.domain.model.model.ImageQuestionType
import com.gg.spora.minigameQuizImage.domain.model.model.QuestionImage
import javax.inject.Inject

class FakeQuizImageLocalRepository @Inject constructor(

): IQuizImageLocalRepository {
//    private val fakeModelsQuiz = FakeQuizImageModels.fakeImageQuestions

    override fun getRandomQuestionsImage(count: Int, type: TypeQuestion): List<Question> {
//        val randomQuestions = fakeModelsQuiz.filter { it.typeQuestion == type }.shuffled().take(count)
        return emptyList()
    }
}
