package com.gg.spora.user.domain.models

import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.grove.data.network.models.ForestTreeNetwork
import com.gg.spora.grove.data.network.models.SeedTreeNetwork

import com.gg.spora.tutorials.domain.model.TutorialCompleted

data class User(
    val id: String,
    val userName: String,
    val email: String,
    val oxygen: Int,
    val treesCount: Int,
    val userImage: Int,
    val levelsCompleted : List<LevelCompleted>,
    val objectsScanned : List<ObjectDetail>,
    var forestTrees: List<ForestTreeNetwork>,
    val seedTrees: List<SeedTreeNetwork>,
    val tutorialsCompleted : List<TutorialCompleted>
)
