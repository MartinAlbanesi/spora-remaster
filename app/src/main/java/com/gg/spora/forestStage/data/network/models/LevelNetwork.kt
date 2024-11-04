package com.gg.spora.forestStage.data.network.models

data class LevelNetwork(
    val id: String? = null,
    val levelName : String? = null,
    val levelNumber: Byte? = null,
    val stageType: String? = null,
    val requiredOxygen: Short? = null,
    val rewardsOxygen: List<Byte>? = null,
    val starState: String? = null,
    val typeQuestion: String? = null,
    val quizCount: Byte? = null,
    val imageCount: Byte? = null,
    val relationsCount: Byte? = null
)