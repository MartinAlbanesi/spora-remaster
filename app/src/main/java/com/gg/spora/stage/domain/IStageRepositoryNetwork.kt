package com.gg.spora.stage.domain

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.stage.domain.model.Level
import kotlinx.coroutines.flow.Flow

interface IStageRepositoryNetwork {

    fun getLevelsByStageType(stageType: StageType): Flow<List<Level>>
}