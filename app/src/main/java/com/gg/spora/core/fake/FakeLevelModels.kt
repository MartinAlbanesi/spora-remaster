package com.gg.spora.core.fake

import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.forestStage.domain.model.TypeLevel

object FakeLevelModels {

    val fakeLevels = listOf(

        Level(
            id = 1,
            levelName = "Nivel 1",
            stage = TypeLevel.FOREST,
            requiredOxygen = 10,
            rewardsOxygen = listOf(10, 20, 30),
        ),
        Level(
            id = 2,
            levelName = "Nivel 2",
            stage = TypeLevel.FOREST,
            requiredOxygen = 20,
            rewardsOxygen = listOf(10, 20, 30),
        ),

        Level(
            id = 3,
            levelName = "Nivel 3",
            stage = TypeLevel.FOREST,
            requiredOxygen = 40,
            rewardsOxygen = listOf(10, 20, 30),
        ),

        Level(
            id = 4,
            levelName = "Nivel 4",
            stage = TypeLevel.FOREST,
            requiredOxygen = 60,
            rewardsOxygen = listOf(10, 20, 30),
        ),

        Level(
            id = 5,
            levelName = "Nivel 5",
            stage = TypeLevel.CHALLENGE,
            requiredOxygen = 80,
            rewardsOxygen = listOf(10, 20, 30),
        ),
    )
}