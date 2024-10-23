package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.ForestTree
import kotlinx.coroutines.flow.Flow

// Caso de uso para obtener los árboles del bosque
class GetForestTreesUseCase(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(): Flow<List<List<ForestTree?>>> = groveRepository.loadForestTreesFromDatabase()
}