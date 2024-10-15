package com.gg.spora.forestStage.data

import com.gg.spora.core.fake.FakeStageModels
import com.gg.spora.core.fake.FakeStageModels.fakeLevels
import com.gg.spora.core.utils.enums.TypeStage
import com.gg.spora.forestStage.domain.IStageRepository
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.forestStage.domain.model.StageLevel
import javax.inject.Inject

class FakeStageLocalRepository @Inject constructor() : IStageRepository {

    private val fakeModels = FakeStageModels

    override fun getStage(typeStage: TypeStage): StageLevel {
        return fakeModels.fakeStage
    }

    override fun getLevels(typeStage: TypeStage): List<Level> {
        return fakeModels.fakeLevels
    }

}