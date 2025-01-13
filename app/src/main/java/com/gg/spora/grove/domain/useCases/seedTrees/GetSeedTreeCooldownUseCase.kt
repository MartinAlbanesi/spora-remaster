package com.gg.spora.grove.domain.useCases.seedTrees

import com.gg.spora.grove.domain.interfaces.ISeedTreeRepositoryLocal
import com.gg.spora.grove.ui.INITIAL_COOLDOWN_DURATION
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.Duration
import java.time.LocalDateTime
import javax.inject.Inject

class GetSeedTreeCooldownUseCase @Inject constructor(
    private val seedTreeRepositoryLocal: ISeedTreeRepositoryLocal
) {
    suspend operator fun invoke(seedTreeId: String): Flow<Long> {
        return seedTreeRepositoryLocal.getCooldownData(seedTreeId).map { cooldownData ->
            val lastUpdateDate = cooldownData.lastUpdateDate
            if (lastUpdateDate != null) {
                val elapsedTime =
                    Duration.between(lastUpdateDate, LocalDateTime.now()).seconds * 1000L
                if (elapsedTime > 0 && !isNegative(INITIAL_COOLDOWN_DURATION - elapsedTime)) {
                    INITIAL_COOLDOWN_DURATION - elapsedTime
                } else {
                    0L
                }
            } else {
                0L
            }
        }
    }

    private fun isNegative(number: Long): Boolean {
        return number < 0L
    }
}