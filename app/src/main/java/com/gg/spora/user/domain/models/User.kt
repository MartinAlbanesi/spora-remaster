package com.gg.spora.user.domain.models

data class User(
    val userId: String,
    val userName: String,
    val email: String,
    val oxygen: Int,
    val levelsCompleted : List<LevelCompleted>
)
