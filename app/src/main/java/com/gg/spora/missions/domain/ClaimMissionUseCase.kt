package com.gg.spora.missions.domain

import com.gg.spora.missions.domain.repository.IMissionRepositoryLocal
import com.gg.spora.user.domain.UpdateUserOxygenUseCase
import javax.inject.Inject

class ClaimMissionUseCase @Inject constructor(
    private val missionRepositoryLocal: IMissionRepositoryLocal,
    private val updateUserOxygenUseCase: UpdateUserOxygenUseCase
) {
    suspend operator fun invoke(missionId: Byte, oxygenReward: Int) {
        missionRepositoryLocal.claimMission(missionId)
        updateUserOxygenUseCase(oxygenReward)
    }
}