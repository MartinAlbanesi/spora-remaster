package com.gg.spora.forestStage.domain

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.forestStage.domain.model.Level

interface IStageRepository {

    fun getLevels(stageType: StageType): List<Level>
}