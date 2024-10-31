package com.gg.spora.core.fake

import com.gg.spora.R
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.core.utils.enums.StageType
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

    var fakeExpoLevels = listOf(
        Level(
            id = "1",
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

    var fakeLevels = listOf(

        Level(
            id = "1",
            levelName = "Nivel 1",
            stageType = StageType.FOREST,
            requiredOxygen = 0,
            rewardsOxygen = listOf(10, 20, 30),
            starState = StarState.ZERO,
            isComplete = true,
            typeQuestion = TypeQuestion.RECYCLE,
            quizCount = 10,
            imageCount = 0,
            relationsCount = 0

        ),
        Level(
            id = "2",
            levelName = "Nivel 2",
            stageType = StageType.FOREST,
            requiredOxygen = 0,
            rewardsOxygen = listOf(15, 25, 35),
            starState = StarState.ZERO,
            isComplete = true,
            typeQuestion = TypeQuestion.RECYCLE,
            quizCount = 0,
            imageCount = 10,
            relationsCount = 0
        ),
        Level(
            id = "3",
            levelName = "Nivel 3",
            stageType = StageType.FOREST,
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

    var fakeStage = listOf(
        StageLevel(
            id = "1",
            stageType = StageType.FOREST,
            levels = fakeLevels,
            challenge = fakeChallenge,
            levelPreviewImage = R.drawable.minigame_background_crop,
            stageBackgroundImage = R.drawable.stage1_area_background,
            pathLadder = SporaConstant.PATH_LADDER
        ),
        StageLevel(
            id = "2",
            stageType = StageType.EXPO,
            levels = fakeExpoLevels,
            challenge = fakeChallenge,
            levelPreviewImage = R.drawable.expo_background,
            stageBackgroundImage = R.drawable.expo_proyecto_stage_background,
            pathLadder = SporaConstant.PATH_LADDER_EXPO
        ),
    )
}