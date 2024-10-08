package com.gg.spora.quiz.data.local

import com.gg.spora.core.fake.FakeQuizModels
import com.gg.spora.core.utils.enums.QuestionType
import com.gg.spora.quiz.domain.IQuizLocalRepository
import com.gg.spora.quiz.domain.model.Question
import javax.inject.Inject

class FakeQuizLocalRepository @Inject constructor(

): IQuizLocalRepository {

    private val fakeModelsQuiz = FakeQuizModels.fakeQuestions

    override fun getRandomQuestions(count: Int, type: QuestionType): List<Question> {
        val randomQuestions = fakeModelsQuiz.filter { it.type == type }.shuffled().take(count)
        return randomQuestions
    }
}