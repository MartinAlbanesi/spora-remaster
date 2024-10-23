package com.gg.spora.forestStage.data

import com.gg.spora.core.fake.FakeStageModels
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.core.utils.enums.TypeStage
import com.gg.spora.forestStage.domain.IStageRepository
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.forestStage.domain.model.StageLevel
import javax.inject.Inject

class FakeStageLocalRepository @Inject constructor() : IStageRepository {

    private var fakeStage = FakeStageModels.fakeStage

    override fun getStage(stageId: String): StageLevel {
        val currentStage = fakeStage.find { it.id == stageId }
        return currentStage!!
    }

    override fun updateLevel(levelId: String, starStageLevel: StarState) {
//        val currentLevel = fakeStage.levels.first { it.id == levelId }
//        if(currentLevel.starState.starCount < starStageLevel.starCount) {
//            val newFakeStage = fakeStage.copy(
//                levels = fakeStage.levels.map {
//                    if(it.id == levelId) {
//                        it.copy(starState = starStageLevel)
//                    } else {
//                        it
//                    }
//                }
//            )
//            fakeStage = newFakeStage
//        }

    }

//    override fun getLevels(typeStage: TypeStage): List<Level> {
//        return fakeModels.fakeLevels
//    }

}