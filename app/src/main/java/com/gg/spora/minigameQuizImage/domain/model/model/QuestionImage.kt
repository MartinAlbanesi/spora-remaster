package com.gg.spora.minigameQuizImage.domain.model.model




data class QuestionImage(
    val id: String,
    val question: String,
    val answers: List<AnswerImage>,
    val answer: AnswerImage,
    val type: ImageQuestionType,
    val imageResId: Int

)

enum class ImageQuestionType {
    RECYCLINGIMAGE,
}
