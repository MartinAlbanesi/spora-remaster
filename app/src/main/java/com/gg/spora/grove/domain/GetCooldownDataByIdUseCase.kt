package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.CooldownData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCooldownDataByIdUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(treeId: String): Flow<CooldownData> {
        return groveRepository.getCooldownData(treeId)
    }
}