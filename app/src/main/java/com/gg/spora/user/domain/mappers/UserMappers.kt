package com.gg.spora.user.domain.mappers

import com.gg.spora.core.utils.functions.getStageTypeByName
import com.gg.spora.core.utils.functions.getStarStateByName
import com.gg.spora.user.data.local.entities.LevelCompletedEntity
import com.gg.spora.user.data.local.entities.UserEntity
import com.gg.spora.user.data.local.entities.UserWithLevelsCompletedEntity
import com.gg.spora.user.data.network.models.UserNetwork
import com.gg.spora.user.domain.models.LevelCompleted
import com.gg.spora.user.domain.models.User

fun UserNetwork.toUser() = User(
    id = id ?: "",
    userName = userName ?: "",
    email = email ?: "",
    oxygen = oxygen ?: 0,
    levelsCompleted = levelsCompleted?.map { it.toLevelCompleted() } ?: emptyList()
)

fun User.toUserEntity() = UserEntity(
    id = id,
    userName = userName,
    email = email,
    oxygen = oxygen,
)

fun LevelCompletedEntity.toLevelCompleted() = LevelCompleted(
    levelId = levelId,
    starState = getStarStateByName(starState),
    stageType = getStageTypeByName(stageType),
)

fun UserWithLevelsCompletedEntity.toUser() = User(
    id = user.id,
    userName = user.userName,
    email = user.email,
    oxygen = user.oxygen,
    levelsCompleted = levelsCompleted.map { it.toLevelCompleted() }
)