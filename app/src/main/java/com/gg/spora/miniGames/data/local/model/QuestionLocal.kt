package com.gg.spora.miniGames.data.local.model

import javax.inject.Inject

data class QuestionLocal @Inject constructor(
    val id: String,
    val question: String,
    val answersLocal: List<AnswerLocal>,
    val answerId: String,
    val typeGame: String,
    val typeQuestion: List<String>,
    val image: String?,
)