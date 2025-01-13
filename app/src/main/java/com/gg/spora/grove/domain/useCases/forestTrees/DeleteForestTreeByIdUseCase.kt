package com.gg.spora.grove.domain.useCases.forestTrees

import com.gg.spora.grove.domain.interfaces.IForestTreeRepositoryLocal
import javax.inject.Inject

/**
 * Use case for deleting a forest tree by its ID.
 */
class DeleteForestTreeByIdUseCase @Inject constructor(
    private val forestTreeRepositoryLocal: IForestTreeRepositoryLocal
) {
    suspend operator fun invoke(treeId: String) {
        forestTreeRepositoryLocal.deleteForestTreeById(treeId)
    }
}