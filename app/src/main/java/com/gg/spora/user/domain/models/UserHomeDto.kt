package com.gg.spora.user.domain.models

data class UserHomeDto(
    val userName: String,
    val oxygen: Int,
    val treesCount: Int,
    val weeklyOxygen: Int,
    val resetDailyMission: Long,
)
