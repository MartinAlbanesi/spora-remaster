package com.gg.spora.stage.data

import com.gg.spora.core.fake.FakeStageModels
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.stage.domain.model.StageLevel
import javax.inject.Inject

class FakeStageLocalRepositoryLocal @Inject constructor()  {

    private var fakeStage = FakeStageModels.fakeStage

    fun getStage(stageType: StageType): StageLevel {
        val currentStage = fakeStage.find { it.stageType == stageType }
        return currentStage!!
    }

//    override fun updateLevel(levelId: String, starStageLevel: StarState) {
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
//
//    }

//    override fun getLevels(typeStage: TypeStage): List<Level> {
//        return fakeModels.fakeLevels
//    }

}