package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.SeedTree
import javax.inject.Inject

/**
 * Use case for saving seed trees to the database.
 */
class SaveSeedTreesUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(seedTrees: List<SeedTree>) {
        groveRepository.insertSeedTreesList(seedTrees)
    }
}