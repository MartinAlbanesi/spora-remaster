package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.GrowthStage
import javax.inject.Inject

class UpdateForestTreeGrowthStageByIdUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(id: Int, newStage: GrowthStage) {
        groveRepository.updateForestTreeGrowthStageById(id, newStage)
    }
}