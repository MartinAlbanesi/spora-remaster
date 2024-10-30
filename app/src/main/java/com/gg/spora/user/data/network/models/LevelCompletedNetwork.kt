package com.gg.spora.user.data.network.models

import com.gg.spora.core.utils.enums.StarState

data class LevelCompletedNetwork(
    val id: String? = null,
    val levelId: String? = null,
    val stageType: String? = null,
    val starState: StarState? = null,
    val rewardsOxygen: List<Byte>? = null
)
