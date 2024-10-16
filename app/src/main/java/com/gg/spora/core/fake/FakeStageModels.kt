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
            isComplete = false,
            typeQuestion = TypeQuestion.RECYCLE,
            quizCount = 8,
            imageCount = 2,
            relationsCount = 0

        ),
        Level(
            id = "2",
            levelName = "Nivel 2",
            typeStage = TypeStage.FOREST,
            requiredOxygen = 30,
            rewardsOxygen = listOf(15, 25, 35),
            starState = StarState.ZERO,
            isComplete = false,
            typeQuestion = TypeQuestion.RECYCLE,
            quizCount = 2,
            imageCount = 8,
            relationsCount = 0
        ),
        //        Level(
//            id = 3,
//            levelName = "Nivel 3",
//            stageType = StageType.FOREST,
//            requiredOxygen = 80,
//            rewardsOxygen = listOf(15, 25, 40),
//            questionType = QuestionType.RELATIONS,
//            starState = StarState.STAR_TWO
//        ),
//        Level(
//            id = "3",
//            levelName = "Desafio",
//            typeStage = TypeStage.FOREST,
//            requiredOxygen = 0,
//            rewardsOxygen = listOf(0, 0, 0),
//            starState = StarState.ZERO,
//            isComplete = false,
//            typeQuestion = TypeQuestion.RECYCLE,
//            quizCount = 4,
//            imageCount = 4,
//            relationsCount = 0
//        )
    )

    var fakeStage = StageLevel(
        id = "1",
        typeStage = TypeStage.FOREST,
        levels = fakeLevels,
        challenge = fakeChallenge
    )
}