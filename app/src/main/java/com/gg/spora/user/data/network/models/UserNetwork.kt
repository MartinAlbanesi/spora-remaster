package com.gg.spora.user.data.network.models

import com.gg.spora.grove.data.network.models.ForestTreeNetwork
import com.gg.spora.grove.data.network.models.SeedTreeNetwork

data class UserNetwork(
    val id: String? = null,
    val userName: String? = null,
    val email: String? = null,
    val oxygen: Int? = null,
    val levelsCompleted : List<LevelCompletedNetwork>? = null,
    val treesCount: Int? = null,
    val userImage: Int? = null,
    val forestTrees: List<ForestTreeNetwork> ?= null,
    val seedTrees: List<SeedTreeNetwork>? = null
)
