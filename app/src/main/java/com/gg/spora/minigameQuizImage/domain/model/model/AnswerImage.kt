package com.gg.spora.minigameQuizImage.domain.model.model

data class AnswerImage(
    val id: String,
    val answer: String,
    val isCorrect: Boolean? = null,
    val type: ImageQuestionType,
    val imageResId: Int
)
