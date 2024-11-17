package com.gg.spora.user.domain.mappers

import com.gg.spora.core.utils.functions.getStageTypeByName
import com.gg.spora.core.utils.functions.getStarStateByName
import com.gg.spora.user.data.local.entities.LevelCompletedEntity
import com.gg.spora.user.domain.models.LevelCompleted
import com.gg.spora.user.data.network.models.LevelCompletedNetwork

fun LevelCompletedNetwork.toLevelCompleted() : LevelCompleted {
    return LevelCompleted(
        levelId = levelId ?: "",
        stageType = getStageTypeByName(stageType ?: ""),
        starState = getStarStateByName(starState ?: ""),
    )
}

fun LevelCompletedEntity.toLevelCompleted() = LevelCompleted(
    levelId = levelId,
    starState = getStarStateByName(starState),
    stageType = getStageTypeByName(stageType),
)

fun LevelCompleted.toLevelCompletedEntity(userId: String) = LevelCompletedEntity(
    levelId = levelId,
    starState = starState.name,
    stageType = stageType.name,
    userId = userId
)