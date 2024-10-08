package com.gg.spora.forestStage.data

import com.gg.spora.core.fake.FakeLevelModels
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.forestStage.domain.IStageRepository
import com.gg.spora.forestStage.domain.model.Level
import javax.inject.Inject

class FakeStageLocalRepository @Inject constructor() : IStageRepository {

    private val fakeLevels = FakeLevelModels.fakeLevels

    override fun getLevels(stageType: StageType): List<Level> {
        return fakeLevels
    }

}