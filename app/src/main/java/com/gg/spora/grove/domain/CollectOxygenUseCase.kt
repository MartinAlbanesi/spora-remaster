package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import javax.inject.Inject

// Caso de uso para reclamar el oxígeno
class CollectOxygenUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(): Int {
        return groveRepository.collectOxygen()
    }
}

