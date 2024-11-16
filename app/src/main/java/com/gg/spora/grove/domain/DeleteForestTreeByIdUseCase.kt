package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import javax.inject.Inject

class DeleteForestTreeByIdUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(treeId: String) {
        groveRepository.deleteForestTreeById(treeId)
    }
}