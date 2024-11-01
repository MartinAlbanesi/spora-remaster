package com.gg.spora.core.fake

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.user.data.local.entities.LevelCompletedEntity
import com.gg.spora.user.data.local.entities.UserEntity
import com.gg.spora.user.domain.models.LevelCompleted
import com.gg.spora.user.domain.models.User

object FakeUserModels {

    val fakeUserEntity = UserEntity("1", "test", "titi@gmail.com", 100)

    val fakeLevelsCompletedEntity = listOf(
        LevelCompletedEntity("1", "stage1", "star1", "1"),
        LevelCompletedEntity("2", "stage2", "star2", "1"),
        LevelCompletedEntity("3", "stage3", "star3", "1")
    )

    private val fakeLevelsCompleted = listOf(
        LevelCompleted(
            levelId = "1",
            stageType = StageType.FOREST,
            starState = StarState.ONE,
        ),
        LevelCompleted(
            levelId = "2",
            stageType = StageType.FOREST,
            starState = StarState.TWO,
        ),
        LevelCompleted(
            levelId = "3",
            stageType = StageType.FOREST,
            starState = StarState.THREE,
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