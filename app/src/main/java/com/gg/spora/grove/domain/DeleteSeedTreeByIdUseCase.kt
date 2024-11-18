package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import javax.inject.Inject

/**
 * Use case for deleting a seed tree by its ID.
 */
class DeleteSeedTreeByIdUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(treeId: String) {
        groveRepository.deleteSeedTreeById(treeId)
    }
}