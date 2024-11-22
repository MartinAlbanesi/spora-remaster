package com.gg.spora.grove.domain

import com.gg.spora.grove.domain.interfaces.IGroveRepository
import com.gg.spora.grove.domain.models.SeedTree
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case for loading seed trees from the database.
 */
class LoadSeedTreesUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(): Flow<List<SeedTree>> {
        return groveRepository.getSeedTreesListFromDatabase()
    }
}