package com.gg.spora.grove.domain

import com.gg.spora.grove.domain.interfaces.IGroveRepository
import com.gg.spora.grove.domain.models.ForestTree
import javax.inject.Inject

class UpdateTimesOxygenClaimedUseCase @Inject constructor(private val groveRepository: IGroveRepository) {
    suspend operator fun invoke(forestTree: ForestTree) {
        groveRepository.updateTimesOxygenClaimed(forestTree)
    }
}