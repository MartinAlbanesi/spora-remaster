package com.gg.spora.core.fake

import com.gg.spora.core.utils.enums.GameType
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState

object FakeLevelModels {

    val fakeLevels = listOf(

        Level(
            id = 1,
            levelName = "Nivel 1",
            stageType = StageType.FOREST,
            requiredOxygen = 0,
            rewardsOxygen = listOf(10, 20, 30),
            gameType = GameType.QUIZ,
            starState = StarState.STAR_THREE
        ),
        Level(
            id = 2,
            levelName = "Nivel 2",
            stageType = StageType.FOREST,
            requiredOxygen = 30,
            rewardsOxygen = listOf(15, 25, 35),
            gameType = GameType.QUIZ_IMAGE,
            starState = StarState.STAR_ONE
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
        Level(
            id = 3,
            levelName = "Desafio",
            stageType = StageType.FOREST,
            requiredOxygen = 0,
            rewardsOxygen = listOf(10, 10, 10),
            gameType = GameType.CHALLENGE
        )
    )
}