package com.gg.spora.quiz.domain.model

import com.gg.spora.core.utils.enums.QuestionType


data class Question(
    val id: String,
    val question: String,
    val answers: List<Answer>,
    val answer: Answer,
    val type: QuestionType
)
