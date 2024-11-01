package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.SeedTree
import kotlinx.coroutines.flow.Flow

class LoadSeedTreesUseCase(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(): Flow<List<SeedTree>> {
        /*
        val seedTreesList = mutableListOf<SeedTree>()
        groveRepository.loadSeedTreesFromDatabase().collect { seedTrees ->
            seedTrees.forEach { seedTree ->
                seedTreesList.add(seedTree)
            }
        }
        return seedTreesList
         */
        return groveRepository.loadSeedTreesFromDatabase()
    }
}