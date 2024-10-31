package com.gg.spora.core.fake

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.user.domain.models.LevelCompleted
import com.gg.spora.user.domain.models.User

object FakeUserModels {

    private val fakeLevelsCompleted = listOf(
        LevelCompleted(
            levelId = "1",
            stageType = StageType.FOREST,
            starState = StarState.ONE,
        ),
        LevelCompleted(
            levelId = "2",
            stageType = StageType.FOREST,
            starState = StarState.THREE,
        ),
        LevelCompleted(
            levelId = "3",
            stageType = StageType.FOREST,
            starState = StarState.TWO,
        )
    )

    val fakeUsers = listOf(
        User(
            id = "1",
            userName = "test",
            email = "titi@gmail.com",
            oxygen = 100,
            levelsCompleted = fakeLevelsCompleted
        ),
    )

}