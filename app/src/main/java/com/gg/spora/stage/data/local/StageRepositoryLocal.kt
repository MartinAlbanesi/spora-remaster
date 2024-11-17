package com.gg.spora.stage.data.local

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.stage.domain.IStageRepositoryLocal
import com.gg.spora.stage.domain.mappers.toLevelEntity
import com.gg.spora.stage.domain.mappers.toLevelList
import com.gg.spora.stage.domain.mappers.toStageLevel
import com.gg.spora.stage.domain.mappers.toStageLevelEntity
import com.gg.spora.stage.domain.model.Level
import com.gg.spora.stage.domain.model.StageLevel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StageRepositoryLocal @Inject constructor(
    private val stageDao: StageDao
) : IStageRepositoryLocal {

    override suspend fun setNewLevels(levels: List<Level>) {
        stageDao.insertLevels(levels.map { it.toLevelEntity() })
    }

    override suspend fun getLevelsCount(): Int {
        return stageDao.getLevelsCount()
    }

    override suspend fun setNewStagesLevel(stageLevels: List<StageLevel>) {
        stageDao.insertStages(stageLevels.map { it.toStageLevelEntity() })
    }

    override suspend fun getStageLevelCount(): Int {
        return stageDao.getStagesCount()
    }

    override suspend fun getStageByStageType(stageType: StageType): StageLevel {
        return stageDao.getStagesByStageType(stageType.name)!!.toStageLevel()
    }

    override fun getLevelsByStageType(stageType: StageType): Flow<List<Level>> {
        return stageDao.getLevelsByStageType(stageType.name)
            .map { it.toLevelList() }
    }
}