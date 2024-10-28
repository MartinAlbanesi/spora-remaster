package com.gg.spora.miniGames.data.local.model

data class AnswerLocal(
    val id: String,
    val answer: String,
    val isCorrect: Boolean?,
    val typeQuestion: List<String>,
    val typeGame: String,
)