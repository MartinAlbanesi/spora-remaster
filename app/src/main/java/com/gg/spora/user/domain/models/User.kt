package com.gg.spora.user.domain.models

import com.gg.spora.tutorials.domain.model.TutorialCompleted

data class User(
    val id: String,
    val userName: String,
    val email: String,
    val oxygen: Int,
    val treesCount: Int,
    val userImage: Int,
    val levelsCompleted : List<LevelCompleted>,
    val tutorialsCompleted : List<TutorialCompleted>
)
