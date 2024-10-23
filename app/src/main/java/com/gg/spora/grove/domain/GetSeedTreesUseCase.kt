package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.SeedTree
import kotlinx.coroutines.flow.Flow

// Caso de uso para obtener los árboles semilleros
class GetSeedTreesUseCase (private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(): Flow<List<SeedTree>> = groveRepository.loadSeedTreesFromDatabase()
}