package com.gg.spora.forestStage.domain

import com.gg.spora.core.utils.enums.TypeStage
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.forestStage.domain.model.StageLevel

interface IStageRepository {

    fun getStage(typeStage: TypeStage): StageLevel

//    fun getLevels(typeStage: TypeStage): List<Level>

    fun updateLevel(level: Level)
}