package com.gg.spora.tutorials.domain.model

data class TutorialCompleted(
    val tutorialId: Int,
    val completed: Boolean,
    val tutorialName: String
)
