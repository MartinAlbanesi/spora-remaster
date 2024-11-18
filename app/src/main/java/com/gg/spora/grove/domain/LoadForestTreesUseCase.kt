package com.gg.spora.grove.domain

import com.gg.spora.grove.domain.interfaces.IGroveRepository
import com.gg.spora.grove.domain.models.ForestTree
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case for loading forest trees from the database.
 */
class LoadForestTreesUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(): Flow<List<ForestTree?>> {
        return groveRepository.getForestTreesListFromDatabase()
    }
}