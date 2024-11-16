package com.gg.spora.user.data.network.models

import com.gg.spora.challenge.data.network.models.ObjectDetailNetwork

data class UserNetwork(
    val id: String? = null,
    val userName: String? = null,
    val email: String? = null,
    val oxygen: Int? = null,
    val levelsCompleted : List<LevelCompletedNetwork>? = null,
    val objectsScanned : List<ObjectDetailNetwork>? = null,
    val treesCount: Int? = null,
    val userImage: Int? = null
)
