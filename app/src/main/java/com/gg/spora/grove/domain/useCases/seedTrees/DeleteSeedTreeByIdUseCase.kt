package com.gg.spora.grove.domain.useCases.seedTrees

import com.gg.spora.grove.domain.interfaces.ISeedTreeRepositoryLocal
import javax.inject.Inject

/**
 * Use case for deleting a seed tree by its ID.
 */
class DeleteSeedTreeByIdUseCase @Inject constructor(
    private val seedTreeRepositoryLocal: ISeedTreeRepositoryLocal
) {
    suspend operator fun invoke(treeId: String) {
        seedTreeRepositoryLocal.deleteSeedTreeById(treeId)
    }
}