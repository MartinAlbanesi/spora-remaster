package com.gg.spora.forestStage.domain

import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.forestStage.domain.model.StageLevel

interface IStageRepository {

    fun getStage(stageId: String): StageLevel

//    fun getLevels(typeStage: TypeStage): List<Level>

    fun updateLevel(levelId: String, starStageLevel: StarState)
}