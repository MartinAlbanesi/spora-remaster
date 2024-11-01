package com.gg.spora.forestStage.domain

import com.gg.spora.core.utils.enums.StarState
import javax.inject.Inject

class UpdateLevelStateUseCase @Inject constructor(
    private val stageRepository: IStageRepositoryLocal
) {
    operator fun invoke(levelId: String, starStageLevel: StarState) {
//        stageRepository.updateLevel(levelId = levelId, starStageLevel = starStageLevel)
    }
}