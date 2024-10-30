package com.gg.spora.registeredLogin.data

import android.health.connect.datatypes.SleepSessionRecord.StageType
import com.gg.spora.core.utils.enums.StarState

data class LevelCompleted(
    val id: String,
    val levelId: String,
    val stageType: StageType,
    val starState: StarState,
    val rewardsOxygen: List<Byte>
)
