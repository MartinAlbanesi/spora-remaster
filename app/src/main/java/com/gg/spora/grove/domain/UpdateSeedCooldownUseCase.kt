package com.gg.spora.grove.domain

import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.SeedTree
import javax.inject.Inject

class UpdateSeedCooldownUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(seedTree: SeedTree) {
        groveRepository.updateSeedTreeCooldown(seedTree)
    }
}