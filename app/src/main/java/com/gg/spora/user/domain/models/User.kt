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
    val levelsCompleted: List<LevelCompleted>,
    var forestTrees: List<ForestTreeNetwork>,
    val seedTrees: List<SeedTreeNetwork>,
    val userImage: String,
    val tutorialsCompleted : List<TutorialCompleted>,
    val weeklyOxygen: Int = 0,
    val objectsScanned : List<ObjectDetail>,
    val resetDailyMission: Long = 0
)
