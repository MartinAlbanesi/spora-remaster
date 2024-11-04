package com.gg.spora.forestStage.domain

import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.forestStage.domain.model.Level
import javax.inject.Inject

class SetNewLevelsUseCase @Inject constructor(
    private val stageRepositoryLocal: IStageRepositoryLocal
) {
    operator fun invoke(levels: List<Level>) {

        val levelsCount = stageRepositoryLocal.getLevelsCount()

        if (levelsCount >= SporaConstant.MAX_LEVELS){
            return
        }

        stageRepositoryLocal.setNewLevels(levels)
    }
}