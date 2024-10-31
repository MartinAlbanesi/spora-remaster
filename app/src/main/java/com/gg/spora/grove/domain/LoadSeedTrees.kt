package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.SeedTree

class LoadSeedTrees(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(): MutableList<SeedTree> {
        val seedTreesList = mutableListOf<SeedTree>()
        groveRepository.loadSeedTreesFromDatabase().collect { seedTrees ->
            seedTrees.forEach { seedTree ->
                seedTreesList.add(seedTree)
            }
        }
        return seedTreesList
    }
}