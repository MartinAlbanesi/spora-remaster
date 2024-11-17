package com.gg.spora.stage.domain.model

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.core.utils.enums.TypeQuestion

data class Level(
    val id: String,
    val levelName : String,
    val levelNumber: Byte,
    val stageType: StageType,
    val requiredOxygen: Short,
    val rewardsOxygen: List<Byte>,
    val starState: StarState = StarState.ZERO,
    val isComplete: Boolean,
    val typeQuestion: TypeQuestion,
    val quizCount: Byte,
    val imageCount: Byte,
    val relationsCount: Byte
)

fun Level.getLevelWithStage(): String {
    return "$levelName - ${stageType.label}"
}