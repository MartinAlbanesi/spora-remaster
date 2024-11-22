package com.gg.spora.missions.domain.models

data class Mission(
    val id: Byte,
    val text: String,
    val oxygenReward: Byte,
    val objective: Byte,
    val counter: Byte,
    val isCompleted: Boolean = false,
    val isClaimed: Boolean = false
)
