package com.gg.spora.quiz.domain.model

import com.gg.spora.core.utils.enums.GameType
import com.gg.spora.core.utils.enums.TypeQuestion


data class Question(
    val id: String,
    val question: String,
    val answers: List<Answer>,
    val answerId: String,
    val gameType: GameType,
    val typeQuestion: TypeQuestion,
)
