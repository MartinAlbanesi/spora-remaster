package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.ForestTree
import kotlinx.coroutines.flow.Flow

class LoadForestTreesUseCase(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(): Flow<List<ForestTree?>> {
        return groveRepository.loadForestTreesFromDatabase()
    }
}