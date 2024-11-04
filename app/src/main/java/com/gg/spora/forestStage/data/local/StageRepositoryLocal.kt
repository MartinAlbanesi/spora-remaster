package com.gg.spora.forestStage.data.local

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.forestStage.domain.IStageRepositoryLocal
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.forestStage.domain.model.StageLevel
import javax.inject.Inject

class StageRepositoryLocal @Inject constructor(

) : IStageRepositoryLocal{
    override fun getStage(stageType: StageType): StageLevel {
        TODO("Not yet implemented")
    }

    override fun setNewLevels(levels: List<Level>) {
        TODO("Not yet implemented")
    }

    override fun getLevelsCount(): Int {
        TODO("Not yet implemented")
    }
}