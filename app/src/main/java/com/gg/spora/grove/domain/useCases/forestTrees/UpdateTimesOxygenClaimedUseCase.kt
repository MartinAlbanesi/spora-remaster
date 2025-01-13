package com.gg.spora.grove.domain.useCases.forestTrees

import com.gg.spora.grove.domain.interfaces.IForestTreeRepositoryLocal
import com.gg.spora.grove.domain.models.ForestTree
import javax.inject.Inject

class UpdateTimesOxygenClaimedUseCase @Inject constructor(
    private val forestTreeRepositoryLocal: IForestTreeRepositoryLocal
) {
    suspend operator fun invoke(forestTree: ForestTree) {
        forestTreeRepositoryLocal.updateTimesOxygenClaimed(forestTree)
    }
}