package com.gg.spora.user.domain.mappers

import com.gg.spora.user.data.network.models.UserNetwork
import com.gg.spora.user.domain.models.User

fun UserNetwork.toUser() = User(
    id = id ?: "",
    userName = userName ?: "",
    email = email ?: "",
    oxygen = oxygen ?: 0,
    levelsCompleted = levelsCompleted?.map { it.toLevelCompleted() } ?: emptyList()
)