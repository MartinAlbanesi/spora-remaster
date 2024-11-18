package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.ForestTree
import javax.inject.Inject

/**
 * Use case for inserting a forest tree.
 */
class InsertForestTreeUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(forestTree: ForestTree) {
        groveRepository.insertForestTree(forestTree)
    }
}