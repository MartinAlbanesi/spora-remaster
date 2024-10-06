package com.gg.spora.grove.domain.models

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.data.models.ForestTree
import kotlinx.coroutines.flow.Flow

// Caso de uso para obtener los árboles del bosque
class GetForestTreesUseCase(private val groveRepository: IGroveRepository) {
    operator fun invoke(): Flow<List<List<ForestTree?>>> = groveRepository.getForestTrees()
}