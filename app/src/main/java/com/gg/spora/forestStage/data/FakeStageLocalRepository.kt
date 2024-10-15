package com.gg.spora.forestStage.data

import com.gg.spora.core.fake.FakeStageModels
import com.gg.spora.core.utils.enums.TypeStage
import com.gg.spora.forestStage.domain.IStageRepository
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.forestStage.domain.model.StageLevel
import javax.inject.Inject

class FakeStageLocalRepository @Inject constructor() : IStageRepository {

    private var fakeStage = FakeStageModels.fakeStage

    override fun getStage(typeStage: TypeStage): StageLevel {
        return fakeStage
    }

    override fun updateLevel(level: Level) {
        val currentLevel = fakeStage.levels.first { it.id == level.id }
        if(currentLevel.starState.starCount < level.starState.starCount) {
            val newFakeStage = fakeStage.copy(
                levels = fakeStage.levels.map {
                    if(it.id == level.id) {
                        level
                    } else {
                        it
                    }
                }
            )
            fakeStage = newFakeStage
        }

    }

//    override fun getLevels(typeStage: TypeStage): List<Level> {
//        return fakeModels.fakeLevels
//    }

}