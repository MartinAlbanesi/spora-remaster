package com.gg.spora.grove.domain.models

import com.gg.spora.grove.data.IGroveRepository

// Caso de uso para reclamar el oxígeno
class CollectOxygenUseCase(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(): Int {
        return groveRepository.collectOxygen()
    }
}

