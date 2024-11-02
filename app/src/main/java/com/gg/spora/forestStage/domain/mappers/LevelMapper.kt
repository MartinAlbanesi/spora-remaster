package com.gg.spora.forestStage.domain.mappers

import com.gg.spora.core.utils.functions.getStageTypeByName
import com.gg.spora.core.utils.functions.getStarStateByName
import com.gg.spora.core.utils.functions.getTypeQuestionByName
import com.gg.spora.forestStage.data.network.models.LevelNetwork
import com.gg.spora.forestStage.domain.model.Level

fun LevelNetwork.toLevel() : Level{
    return Level(
        id = id ?: "",
        levelName = levelName ?: "",
        stageType = getStageTypeByName(stageType ?: ""),
        requiredOxygen = requiredOxygen ?: 0,
        rewardsOxygen = rewardsOxygen ?: emptyList(),
        starState = getStarStateByName(starState ?: ""),
        isComplete = false,
        typeQuestion = getTypeQuestionByName(typeQuestion ?: ""),
        quizCount = quizCount ?: 0,
        imageCount = imageCount ?: 0,
        relationsCount = relationsCount ?: 0
    )
}