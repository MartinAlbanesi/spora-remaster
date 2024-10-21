package com.gg.spora.grove.domain.models

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.data.models.ForestTree
import com.gg.spora.grove.data.models.Seed

// Caso de uso para plantar una semilla
class PlantSeedUseCase(private val groveRepository: IGroveRepository) {
    operator fun invoke(seed: Seed): ForestTree? {
        return groveRepository.plantSeed(seed)
    }
}