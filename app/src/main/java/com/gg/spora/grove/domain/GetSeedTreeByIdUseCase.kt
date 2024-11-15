package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.SeedTree
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSeedTreeByIdUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(id: String): Flow<SeedTree?> {
        return groveRepository.getSeedTreeById(id = id)
    }
}