package com.gg.spora.quiz.domain.model

import androidx.compose.ui.graphics.Color

data class Answer(
    val id: String,
    val answer: String,
    val isCorrect: Boolean? = null,
    val type: QuestionType,
    val textColor: Color = Color(0xff442801),
    val backgroundColor: Color = Color(0xFFffeacc),
)
