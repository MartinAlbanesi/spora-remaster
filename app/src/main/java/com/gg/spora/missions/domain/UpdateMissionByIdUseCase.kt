package com.gg.spora.missions.domain

import com.gg.spora.missions.domain.models.Mission
import com.gg.spora.missions.domain.repository.IMissionRepositoryLocal
import javax.inject.Inject

class UpdateMissionByIdUseCase @Inject constructor(
    private val missionRepositoryLocal: IMissionRepositoryLocal
) {
    suspend operator fun invoke(
        missionId: Byte,
    ):Mission? {

        missionRepositoryLocal.updateCounterMission(missionId)

        val missionLocal = missionRepositoryLocal.getMissionById(missionId)

        missionLocal?.let {
            if(missionLocal.counter == missionLocal.objective){
                return missionLocal
            }
        }

        return null
    }
}