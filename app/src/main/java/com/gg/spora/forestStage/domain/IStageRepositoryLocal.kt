package com.gg.spora.forestStage.domain

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.forestStage.domain.model.StageLevel
import kotlinx.coroutines.flow.Flow

interface IStageRepositoryLocal {


    suspend fun setNewLevels(levels: List<Level>)

    suspend fun getLevelsCount(): Int

    suspend fun setNewStagesLevel(stageLevels: List<StageLevel>)

    suspend fun getStageLevelCount(): Int

    suspend fun getStageByStageType(stageType: StageType): StageLevel

    fun getLevelsByStageType(stageType: StageType): Flow<List<Level>>
}