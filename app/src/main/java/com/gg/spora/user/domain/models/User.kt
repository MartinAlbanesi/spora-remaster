package com.gg.spora.user.domain.models

import com.gg.spora.registeredLogin.data.LevelCompleted

data class User(
    val userId: String,
    val userName: String,
    val email: String,
    val oxygen: Int,
    val levelsCompleted : List<LevelCompleted>
)
