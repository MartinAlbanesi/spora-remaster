package com.gg.spora.forestStage

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.forestStage.domain.model.Level
import kotlinx.coroutines.flow.Flow

interface IStageRepositoryNetwork {

    fun getLevelsByStageType(stageType: StageType): Flow<List<Level>>
}