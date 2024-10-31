package com.gg.spora.forestStage.data.network.models

data class LevelNetwork(
    val id: String? = null,
    val levelName : String? = null,
    val stageType: String? = null,
    val requiredOxygen: Int? = null,
    val rewardsOxygen: List<Int>? = null,
    val starState: String? = null,
    val typeQuestion: String? = null,
    val quizCount: Int? = null,
    val imageCount: Int? = null,
    val relationsCount: Int? = null
)