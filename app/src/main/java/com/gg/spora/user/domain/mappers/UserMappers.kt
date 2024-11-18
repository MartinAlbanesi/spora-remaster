package com.gg.spora.user.domain.mappers

import com.gg.spora.R
import com.gg.spora.user.data.local.entities.UserEntity
import com.gg.spora.user.data.local.entities.UserWithLevelsCompletedEntity
import com.gg.spora.user.data.network.models.UserNetwork
import com.gg.spora.user.domain.models.User

fun UserNetwork.toUser() = User(
    id = id ?: "",
    userName = userName ?: "",
    email = email ?: "",
    oxygen = oxygen ?: 0,
    levelsCompleted = levelsCompleted?.map { it.toLevelCompleted() } ?: emptyList(),
    treesCount = treesCount ?: 0,
    userImage = userImage ?: R.drawable.spora_face_splash,
    weeklyOxygen = weeklyOxygen ?: 0
)

fun User.toUserEntity() = UserEntity(
    id = id,
    userName = userName,
    email = email,
    oxygen = oxygen,
    treesCount = treesCount,
    userImage = userImage,
    weeklyOxygen = weeklyOxygen
)

fun UserWithLevelsCompletedEntity.toUser() = User(
    id = user.id,
    userName = user.userName,
    email = user.email,
    oxygen = user.oxygen,
    levelsCompleted = levelsCompleted.map { it.toLevelCompleted() },
    treesCount = user.treesCount,
    userImage = user.userImage,
    weeklyOxygen = user.weeklyOxygen
)