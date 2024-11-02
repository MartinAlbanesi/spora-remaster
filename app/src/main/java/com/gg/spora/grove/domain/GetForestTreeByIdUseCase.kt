package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.ForestTree
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetForestTreeByIdUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(id: Int): Flow<ForestTree?> {
        return groveRepository.getForestTreeById(id = id)
    }
}