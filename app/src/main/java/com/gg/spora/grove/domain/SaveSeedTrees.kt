package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.SeedTree

class SaveSeedTrees(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(seedTrees: List<SeedTree>) {
        groveRepository.saveSeedTrees(seedTrees)
    }
}