package com.gg.spora.forestStage.domain.model

import com.gg.spora.core.utils.enums.QuestionType
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState

data class Level(
    val id: Int,
    val levelName : String,
    val stageType: StageType,
    val requiredOxygen: Int,
    val rewardsOxygen: List<Int>,
    val questionType: QuestionType,
    val starState: StarState = StarState.STAR_ZERO
)