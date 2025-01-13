package com.gg.spora.grove.domain.useCases.seedTrees

import com.gg.spora.grove.domain.interfaces.ISeedTreeRepositoryLocal
import com.gg.spora.grove.domain.models.CooldownData
import javax.inject.Inject

/**
 * Use case for inserting cooldown data.
 */
class InsertCooldownDataUseCase @Inject constructor(
    private val seedTreeRepositoryLocal: ISeedTreeRepositoryLocal
) {
    suspend operator fun invoke(cooldownData: CooldownData) {
        seedTreeRepositoryLocal.insertCooldownData(cooldownData)
    }
}