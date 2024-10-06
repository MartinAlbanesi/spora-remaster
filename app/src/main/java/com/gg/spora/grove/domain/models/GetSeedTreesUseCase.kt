package com.gg.spora.grove.domain.models

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.data.models.SeedTree
import kotlinx.coroutines.flow.Flow

// Caso de uso para obtener los árboles semilleros
class GetSeedTreesUseCase(private val groveRepository: IGroveRepository) {
    operator fun invoke(): Flow<List<SeedTree>> = groveRepository.getSeedTrees()
}