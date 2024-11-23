package com.gg.spora.user.domain.models

import com.gg.spora.tutorials.domain.model.TutorialCompleted

import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree

data class User(
    val id: String,
    val userName: String,
    val email: String,
    val oxygen: Int,
    val treesCount: Int,
    val levelsCompleted: List<LevelCompleted>,
    var forestTrees: List<ForestTree>,
    val seedTrees: List<SeedTree>,
    val userImage: String,
    val tutorialsCompleted : List<TutorialCompleted>,
    val weeklyOxygen: Int = 0
)
