package com.gg.spora.quiz.domain.model

data class Answer(
    val id: String,
    val answer: String,
    val isCorrect: Boolean? = null,
    val type: QuestionType,
)
