package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.ForestTree

class SaveForestTreesUseCase(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(forestTrees: List<ForestTree?>) {
        groveRepository.saveForestTrees(forestTrees)
    }
}