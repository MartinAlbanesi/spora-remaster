package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.ForestTree

class InsertForestTreeUseCase(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(forestTree: ForestTree) {
        groveRepository.insertForestTree(forestTree)
    }
}