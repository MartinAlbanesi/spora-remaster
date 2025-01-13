package com.gg.spora.grove.domain.useCases.seedTrees

import com.gg.spora.grove.domain.interfaces.ISeedTreeRepositoryLocal
import com.gg.spora.grove.domain.models.CooldownData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case for getting cooldown data by tree ID.
 */
class GetCooldownDataByIdUseCase @Inject constructor(
    private val seedTreeRepositoryLocal: ISeedTreeRepositoryLocal
) {
    suspend operator fun invoke(treeId: String): Flow<CooldownData> {
        return seedTreeRepositoryLocal.getCooldownData(treeId)
    }
}