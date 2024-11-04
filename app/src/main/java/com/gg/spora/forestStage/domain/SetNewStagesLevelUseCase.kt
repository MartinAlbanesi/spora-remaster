package com.gg.spora.forestStage.domain

import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.forestStage.domain.model.StageLevel
import javax.inject.Inject

class SetNewStagesLevelUseCase @Inject constructor(
    private val stageRepositoryLocal: IStageRepositoryLocal,
) {
    operator fun invoke(
        stageLevels: List<StageLevel>
    ) {

        val stageLevelCount = stageRepositoryLocal.getStageLevelCount()

        if (stageLevelCount >= SporaConstant.MAX_STAGES_LEVEL) {
            return
        }

        stageRepositoryLocal.setNewStagesLevel(stageLevels)
    }
}