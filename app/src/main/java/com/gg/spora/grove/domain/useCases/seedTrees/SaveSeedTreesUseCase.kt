package com.gg.spora.grove.domain.useCases.seedTrees

import com.gg.spora.grove.domain.interfaces.ISeedTreeRepositoryLocal
import com.gg.spora.grove.domain.models.SeedTree
import javax.inject.Inject

/**
 * Use case for saving seed trees to the database.
 */
class SaveSeedTreesUseCase @Inject constructor(
    private val seedTreeRepositoryLocal: ISeedTreeRepositoryLocal
)
{
    suspend operator fun invoke(seedTrees: List<SeedTree>) {
        seedTreeRepositoryLocal.insertSeedTreesList(seedTrees)
    }
}