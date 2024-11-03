package com.gg.spora.user.domain.models

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState

data class LevelCompleted(
    val levelId: String,
    val stageType: StageType,
    val starState: StarState,
//    val rewardsOxygen: List<Byte>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LevelCompleted

        return levelId == other.levelId
    }

    override fun hashCode(): Int {
        return levelId.hashCode()
    }
}


