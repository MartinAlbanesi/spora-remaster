package com.gg.spora.grove.domain

import com.gg.spora.grove.domain.interfaces.IGroveRepository
import javax.inject.Inject

/**
 * Use case for deleting a forest tree by its ID.
 */
class DeleteForestTreeByIdUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(treeId: String) {
        groveRepository.deleteForestTreeById(treeId)
    }
}