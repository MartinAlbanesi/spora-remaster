package com.gg.spora.minigameQuizImage.domain.model

import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.model.Question
import com.gg.spora.minigameQuizImage.domain.model.model.ImageQuestionType
import com.gg.spora.minigameQuizImage.domain.model.model.QuestionImage

interface IQuizImageLocalRepository {

    fun getRandomQuestionsImage(count: Int, type: TypeQuestion): List<Question>
}
