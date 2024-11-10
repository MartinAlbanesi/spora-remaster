package com.gg.spora.stage.domain.mappers

import com.gg.spora.core.utils.functions.getStageTypeByName
import com.gg.spora.core.utils.functions.getStarStateByName
import com.gg.spora.core.utils.functions.getTypeQuestionByName
import com.gg.spora.stage.data.local.models.LevelEntity
import com.gg.spora.stage.data.network.models.LevelNetwork
import com.gg.spora.stage.domain.model.Level

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
        relationsCount = relationsCount ?: 0,
        levelNumber = levelNumber ?: 0
    )
}

fun Level.toLevelEntity() : LevelEntity {
    return LevelEntity(
        id = id,
        levelName = levelName,
        levelNumber = levelNumber,
        stageType = stageType.name,
        requiredOxygen = requiredOxygen,
        rewardsOxygen = rewardsOxygen.joinToString(","),
        starState = starState.name,
        typeQuestion = typeQuestion.name,
        quizCount = quizCount,
        imageCount = imageCount,
        relationsCount = relationsCount
    )
}

fun LevelEntity.toLevel() : Level{
    return Level(
        id = id,
        levelName = levelName,
        levelNumber = levelNumber,
        stageType = getStageTypeByName(stageType),
        requiredOxygen = requiredOxygen,
        rewardsOxygen = rewardsOxygen.split(",").map { it.toByte() },
        starState = getStarStateByName(starState),
        isComplete = false,
        typeQuestion = getTypeQuestionByName(typeQuestion),
        quizCount = quizCount,
        imageCount = imageCount,
        relationsCount = relationsCount
    )
}

fun List<LevelEntity>.toLevelList() : List<Level>{
    return map { it.toLevel() }
}