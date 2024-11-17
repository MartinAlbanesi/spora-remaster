package com.gg.spora.tutorials.domain.model

data class TutorialCompleted(
    val tutorialId: Int,
    val isCompleted: Boolean,
    val tutorialName: String
)
