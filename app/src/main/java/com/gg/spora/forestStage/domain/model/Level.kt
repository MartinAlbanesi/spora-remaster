package com.gg.spora.forestStage.domain.model

data class Level(
    val id: Int,
    val levelName : String,
    val stage: TypeLevel,
    val requiredOxygen: Int,
    val rewardsOxygen: List<Int>,
)