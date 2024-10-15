package com.gg.spora.core.fake

import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.core.utils.enums.TypeQuestion

object FakeLevelModels {

    val fakeLevels = listOf(

        Level(
            id = "1",
            levelName = "Nivel 1",
            stageType = StageType.FOREST,
            requiredOxygen = 0,
            rewardsOxygen = listOf(10, 20, 30),
            starState = StarState.THREE,
            isComplete = true,
            typeQuestion = TypeQuestion.RECYCLE,
            quizCount = 4,
            imageCount = 4,
            relationsCount = 0

        ),
        Level(
            id = "2",
            levelName = "Nivel 2",
            stageType = StageType.FOREST,
            requiredOxygen = 30,
            rewardsOxygen = listOf(15, 25, 35),
            starState = StarState.ZERO,
            isComplete = false,
            typeQuestion = TypeQuestion.RECYCLE,
            quizCount = 3,
            imageCount = 5,
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
//            levelName = "Nivel 3",
//            stageType = StageType.FOREST,
//            requiredOxygen = 0,
//            levelState = LevelState(
//                rewardOxygen = listOf(15, 25, 40),
//                starState = StarState.ZERO,
//                isComplete = false,
//                typeQuestion = TypeQuestion.RECYCLE,
//                quizCount = 0,
//                imageCount = 0,
//                relationsCount = 3
//            )
//        )
    )
}