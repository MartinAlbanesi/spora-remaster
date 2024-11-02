package com.gg.spora.user.domain.models

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState

data class LevelCompleted(
    val levelId: String,
    val stageType: StageType,
    val starState: StarState,
//    val rewardsOxygen: List<Byte>
)
