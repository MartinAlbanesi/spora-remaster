package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.ForestTree
import javax.inject.Inject

/**
 * Use case for updating the growth stage of a forest tree in the database.
 */
class UpdateForestTreeGrowthStageByIdUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(forestTree: ForestTree) {
        groveRepository.updateForestTreeGrowthStage(forestTree)
    }
}