package com.gg.spora.grove.domain

import com.gg.spora.grove.domain.interfaces.IGroveRepository
import com.gg.spora.grove.domain.models.CooldownData
import javax.inject.Inject

/**
 * Use case for inserting cooldown data.
 */
class InsertCooldownDataUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(cooldownData: CooldownData) {
        groveRepository.insertCooldownData(cooldownData)
    }
}