package com.gg.spora.minigameQuiz.domain

import java.util.UUID

data class Question(
    val id: String = UUID.randomUUID().toString(),
    val question: String,
    val answerOptions: List<Answer>,
    val answer: Answer,
)

data class Answer(
    val id: String = UUID.randomUUID().toString(),
    val answer: String,
    val isCorrect: Boolean?,
)
