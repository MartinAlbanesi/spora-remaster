package com.gg.spora.quiz.domain.model

import com.gg.spora.core.utils.enums.QuestionType

data class Answer(
    val id: String,
    val answer: String,
    val isCorrect: Boolean? = null,
    val type: QuestionType,
)
