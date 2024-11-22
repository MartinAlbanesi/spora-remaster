package com.gg.spora.user.domain.models

data class User(
    val id: String,
    var userName: String,
    val email: String,
    val oxygen: Int,
    val weeklyOxygen: Int,
    val treesCount: Int,
    var userImage: String,
    val levelsCompleted : List<LevelCompleted>,
    val weeklyOxygen: Int
)
