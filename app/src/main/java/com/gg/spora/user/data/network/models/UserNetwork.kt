package com.gg.spora.user.data.network.models

data class UserNetwork(
    val userId: String? = null,
    val userName: String? = null,
    val email: String? = null,
    val oxygen: Int? = null,
    val levelsCompleted : List<LevelCompletedNetwork>? = null
)
