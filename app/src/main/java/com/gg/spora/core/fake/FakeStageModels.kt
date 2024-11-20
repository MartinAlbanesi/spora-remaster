package com.gg.spora.core.fake

import com.gg.spora.R
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.stage.data.local.models.LevelEntity
import com.gg.spora.stage.data.local.models.StageLevelEntity
import com.gg.spora.stage.domain.model.Level
import com.gg.spora.stage.domain.model.StageLevel
import com.gg.spora.miniGames.domain.model.Challenge

object FakeStageModels {

    var fakeChallenge = Challenge(
        id = "1",
        objets = mapOf(
            "Botella de plastico" to false,
        ),
    )

//    var fakeExpoLevels = listOf(
//        Level(
//            id = "1",
//            levelName = "Expo",
//            stageType = StageType.EXPO,
//            requiredOxygen = 0,
//            rewardsOxygen = listOf(10, 20, 30),
//            starState = StarState.ZERO,
//            isComplete = true,
//            typeQuestion = TypeQuestion.RECYCLE,
//            quizCount = 2,
//            imageCount = 2,
//            relationsCount = 2
//        ),
//    )

    val fakeLevelsEntity = listOf(
        LevelEntity(
            "1",
            "level1",
            1,
            "FOREST",
            10,
            "10,20,30",
            "ZERO",
            "RECYCLE",
            3,
            3,
            4
        ),
        LevelEntity(
            "2",
            "level2",
            2,
            "FOREST",
            20,
            "15,25,35",
            "ZERO",
            "RECYCLE",
            3,
            5,
            2
        ),
    )

    var fakeLevels = listOf(

        Level(
            id = "1",
            levelNumber = 1,
            levelName = "Nivel 1",
            stageType = StageType.FOREST,
            requiredOxygen = 0,
            rewardsOxygen = listOf(10, 20, 30),
            starState = StarState.ZERO,
            isComplete = true,
            typeQuestion = TypeQuestion.RECYCLE,
            quizCount = 5,
            imageCount = 3,
            relationsCount = 2

        ),
        Level(
            id = "2",
            levelNumber = 2,
            levelName = "Nivel 2",
            stageType = StageType.FOREST,
            requiredOxygen = 0,
            rewardsOxygen = listOf(15, 25, 35),
            starState = StarState.ZERO,
            isComplete = true,
            typeQuestion = TypeQuestion.RECYCLE,
            quizCount = 3,
            imageCount = 5,
            relationsCount = 2
        ),
        Level(
            id = "3",
            levelNumber = 3,
            levelName = "Nivel 3",
            stageType = StageType.FOREST,
            requiredOxygen = 30,
            rewardsOxygen = listOf(15, 25, 35),
            starState = StarState.ZERO,
            isComplete = true,
            typeQuestion = TypeQuestion.RECYCLE,
            quizCount = 2,
            imageCount = 3,
            relationsCount = 5
        ),
        Level(
            id = "4",
            levelNumber = 1,
            levelName = "Expo",
            stageType = StageType.EXPO,
            requiredOxygen = 0,
            rewardsOxygen = listOf(10, 20, 30),
            starState = StarState.ZERO,
            isComplete = true,
            typeQuestion = TypeQuestion.RECYCLE,
            quizCount = 2,
            imageCount = 2,
            relationsCount = 2
        ),
    )

    val fakeStageEntities = listOf(
        StageLevelEntity(
            "1",
            "FOREST",
            R.drawable.minigame_background_crop,
            R.drawable.forest_area_rework,
        ),
        StageLevelEntity(
            "2",
            "EXPO",
            R.drawable.expo_background,
            R.drawable.expo_proyecto_stage_background,
        ),
    )

    var fakeStage = listOf(
        StageLevel(
            id = "1",
            stageType = StageType.FOREST,
//            levels = fakeLevels,
//            challenge = fakeChallenge,
            levelPreviewImage = R.drawable.minigame_background_crop,
            stageBackgroundImage = R.drawable.forest_area_rework,
            pathLadder = SporaConstant.PATH_LADDER
        ),
        StageLevel(
            id = "2",
            stageType = StageType.EXPO,
//            levels = fakeExpoLevels,
//            challenge = fakeChallenge,
            levelPreviewImage = R.drawable.expo_background,
            stageBackgroundImage = R.drawable.expo_proyecto_stage_background,
            pathLadder = SporaConstant.PATH_LADDER_EXPO
        ),
    )
}