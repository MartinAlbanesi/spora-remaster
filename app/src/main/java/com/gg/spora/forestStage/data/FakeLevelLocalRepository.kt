package com.gg.spora.forestStage.data

import com.gg.spora.core.fake.FakeLevelModels
import com.gg.spora.forestStage.domain.ILevelRepository
import com.gg.spora.forestStage.domain.model.Level
import javax.inject.Inject

class FakeLevelLocalRepository @Inject constructor() : ILevelRepository {

    private val fakeLevels = FakeLevelModels.fakeLevels
    override fun getLevels(count: Int, typeLevel: Level): List<Level> {
        return fakeLevels
    }

}