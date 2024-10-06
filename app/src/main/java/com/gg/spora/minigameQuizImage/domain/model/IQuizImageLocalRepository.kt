package com.gg.spora.minigameQuizImage.domain.model

import com.gg.spora.minigameQuizImage.domain.model.model.ImageQuestionType
import com.gg.spora.minigameQuizImage.domain.model.model.QuestionImage

interface IQuizImageLocalRepository {

    fun getRandomQuestionsImage(count: Int, type: ImageQuestionType): List<QuestionImage>
}
