package com.gg.spora.core.fake

import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.core.utils.enums.TypeStage
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.forestStage.domain.model.StageLevel
import com.gg.spora.miniGames.domain.model.Challenge

object FakeStageModels {

    var fakeChallenge = Challenge(
        id = "1",
        objets = mapOf(
            "Botella de plastico" to false,
        ),
    )

    var fakeLevels = listOf(

        Level(
            id = "1",
            levelName = "Nivel 1",
            typeStage = TypeStage.FOREST,
            requiredOxygen = 0,
            rewardsOxygen = listOf(10, 20, 30),
            starState = StarState.ZERO,
            isComplete = true,
            typeQuestion = TypeQuestion.RECYCLE,
            quizCount = 5,
            imageCount = 5,
            relationsCount = 0

        ),
        Level(
            id = "2",
            levelName = "Nivel 2",
            typeStage = TypeStage.FOREST,
            requiredOxygen = 0,
            rewardsOxygen = listOf(15, 25, 35),
            starState = StarState.ZERO,
            isComplete = true,
            typeQuestion = TypeQuestion.RECYCLE,
            quizCount = 2,
            imageCount = 8,
            relationsCount = 0
        ),
        Level(
            id = "3",
            levelName = "Nivel 3",
            typeStage = TypeStage.FOREST,
            requiredOxygen = 30,
            rewardsOxygen = listOf(15, 25, 35),
            starState = StarState.ZERO,
            isComplete = true,
            typeQuestion = TypeQuestion.RECYCLE,
            quizCount = 0,
            imageCount = 0,
            relationsCount = 10
        ),
    )

    var fakeStage = StageLevel(
        id = "1",
        typeStage = TypeStage.FOREST,
        levels = fakeLevels,
        challenge = fakeChallenge
    )
}