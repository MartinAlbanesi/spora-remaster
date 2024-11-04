package com.gg.spora.forestStage.domain

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.forestStage.domain.model.StageLevel

interface IStageRepositoryLocal {


    fun setNewLevels(levels: List<Level>)

    fun getLevelsCount(): Int

    fun setNewStagesLevel(stageLevels: List<StageLevel>)

    fun getStageLevelCount(): Int

    fun getStage(stageType: StageType): StageLevel
//    fun getLevels(typeStage: TypeStage): List<Level>

//    fun updateLevel(levelId: String, starStageLevel: StarState)
}