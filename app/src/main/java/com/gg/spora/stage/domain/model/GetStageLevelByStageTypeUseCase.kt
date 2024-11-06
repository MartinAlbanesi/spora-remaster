package com.gg.spora.stage.domain.model

import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.stage.domain.IStageRepositoryLocal
import javax.inject.Inject

class GetStageLevelByStageTypeUseCase @Inject constructor(
    private val stageRepositoryLocal: IStageRepositoryLocal
) {
    suspend operator fun invoke(
        stageType: StageType
    ) : StageLevel {
        return stageRepositoryLocal.getStageByStageType(stageType)
    }
}