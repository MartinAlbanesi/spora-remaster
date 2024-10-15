package com.gg.spora.miniGames.domain.model

import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion


data class Question(
    val id: String,
    val question: String,
    val answers: List<Answer>,
    val answerId: String,
    val typeGame: TypeGame,
    val typeQuestion: TypeQuestion,
)
