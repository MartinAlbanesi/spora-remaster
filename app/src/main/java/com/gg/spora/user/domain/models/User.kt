package com.gg.spora.user.domain.models

data class User(
    val id: String,
    val userName: String,
    val email: String,
    val oxygen: Int,
    val treesCount: Int,
    var userImage: Int,
    val levelsCompleted : List<LevelCompleted>,
    val weeklyOxygen: Int
)
