package com.gg.spora.user.domain.mappers

import com.gg.spora.core.utils.functions.getStageTypeByName
import com.gg.spora.core.utils.functions.getStarStateByName
import com.gg.spora.user.domain.models.LevelCompleted
import com.gg.spora.user.data.network.models.LevelCompletedNetwork

fun LevelCompletedNetwork.toLevelCompleted() : LevelCompleted {
    return LevelCompleted(
        levelId = levelId ?: "",
        stageType = getStageTypeByName(stageType ?: ""),
        starState = getStarStateByName(starState ?: ""),
        rewardsOxygen = rewardsOxygen ?: emptyList(),
    )
}