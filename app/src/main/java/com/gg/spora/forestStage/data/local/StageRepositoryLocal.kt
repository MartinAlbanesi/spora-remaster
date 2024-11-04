package com.gg.spora.forestStage.data.local

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.forestStage.domain.IStageRepositoryLocal
import com.gg.spora.forestStage.domain.mappers.toLevelEntity
import com.gg.spora.forestStage.domain.mappers.toStageLevelEntity
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.forestStage.domain.model.StageLevel
import javax.inject.Inject

class StageRepositoryLocal @Inject constructor(
    private val stageDao: StageDao
) : IStageRepositoryLocal{
    override fun getStage(stageType: StageType): StageLevel {
        TODO("Not yet implemented")
    }

    override fun setNewLevels(levels: List<Level>) {
        stageDao.insertLevels(levels.map { it.toLevelEntity() })
    }

    override fun getLevelsCount(): Int {
        return stageDao.getLevelsCount()
    }

    override fun setNewStagesLevel(stageLevels: List<StageLevel>) {
        stageDao.insertStages(stageLevels.map { it.toStageLevelEntity() })
    }

    override fun getStageLevelCount(): Int {
        return stageDao.getStagesCount()
    }
}