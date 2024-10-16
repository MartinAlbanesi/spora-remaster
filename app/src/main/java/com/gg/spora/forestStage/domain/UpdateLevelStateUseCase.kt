package com.gg.spora.forestStage.domain

import com.gg.spora.core.utils.enums.StarState
import com.gg.spora.forestStage.domain.model.Level
import javax.inject.Inject

class UpdateLevelStateUseCase @Inject constructor(
    private val stageRepository: IStageRepository
) {
    operator fun invoke(levelId: String, starStageLevel: StarState) {
        stageRepository.updateLevel(levelId = levelId, starStageLevel = starStageLevel)
    }
}