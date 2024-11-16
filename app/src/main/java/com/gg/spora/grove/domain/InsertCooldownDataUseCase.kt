package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.CooldownData
import javax.inject.Inject

class InsertCooldownDataUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(cooldownData: CooldownData) {
        groveRepository.insertCooldownData(cooldownData)
    }
}