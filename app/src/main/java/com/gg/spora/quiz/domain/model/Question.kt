package com.gg.spora.quiz.domain.model


data class Question(
    val id: String,
    val question: String,
    val answers: List<Answer>,
    val answer: Answer,
    val type: QuestionType
)

enum class QuestionType {
    RECYCLING,
}
