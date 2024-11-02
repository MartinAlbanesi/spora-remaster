package com.gg.spora.user.data.network.models

data class LevelCompletedNetwork(
    val levelId: String? = null,
    val stageType: String? = null,
    val starState: String? = null,
    val rewardsOxygen: List<Byte>? = null
)
