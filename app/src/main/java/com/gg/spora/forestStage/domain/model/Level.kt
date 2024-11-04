package com.gg.spora.forestStage.domain.model

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.core.utils.enums.TypeQuestion

data class Level(
    val id: String,
    val levelName : String,
    val levelNumber: Byte,
    val stageType: StageType,
    val requiredOxygen: Int,
    val rewardsOxygen: List<Int>,
    val starState: StarState = StarState.ZERO,
    val isComplete: Boolean,
    val typeQuestion: TypeQuestion,
    val quizCount: Int,
    val imageCount: Int,
    val relationsCount: Int
)

fun Level.getLevelWithStage(): String {
    return "$levelName - ${stageType.label}"
}