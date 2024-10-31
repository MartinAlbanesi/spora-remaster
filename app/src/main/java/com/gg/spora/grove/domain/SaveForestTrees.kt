package com.gg.spora.grove.domain

import com.gg.spora.grove.data.GroveRepository
import com.gg.spora.grove.domain.models.ForestTree

class SaveForestTrees(private val groveRepository: GroveRepository) {
    suspend operator fun invoke(forestTrees: List<ForestTree>) {
        groveRepository.saveForestTrees(forestTrees)
    }
}