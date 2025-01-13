package com.gg.spora.grove.domain.useCases.forestTrees

import com.gg.spora.grove.domain.interfaces.IForestTreeRepositoryLocal
import com.gg.spora.grove.domain.models.ForestTree
import javax.inject.Inject

/**
 * Use case for updating the growth stage of a forest tree in the database.
 */
class UpdateForestTreeGrowthStageByIdUseCase @Inject constructor(
    private val forestTreeRepositoryLocal: IForestTreeRepositoryLocal
) {
    suspend operator fun invoke(forestTree: ForestTree) {
        forestTreeRepositoryLocal.updateForestTreeGrowthStage(forestTree)
    }
}