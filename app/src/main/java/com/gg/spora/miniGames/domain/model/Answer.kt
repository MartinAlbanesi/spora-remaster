package com.gg.spora.miniGames.domain.model

import com.gg.spora.core.utils.enums.TypeQuestion

data class Answer(
    val id: String,
    val answer: String,
    val isCorrect: Boolean? = null,
    val type: TypeQuestion,
)
