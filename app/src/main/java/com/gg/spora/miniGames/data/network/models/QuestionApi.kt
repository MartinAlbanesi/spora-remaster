package com.gg.spora.miniGames.data.network.models

data class QuestionApi(
    val id: String? = null,
    val question: String? = null,
    val answers: List<AnswerApi>? = null,
    val answerId: String? = null,
    val typeGame: String? = null,
    val typeQuestion: String? = null,
    val image: Int? = null
)
