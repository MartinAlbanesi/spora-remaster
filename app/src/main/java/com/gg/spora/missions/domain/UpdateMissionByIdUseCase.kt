package com.gg.spora.missions.domain

import android.util.Log
import com.gg.spora.missions.domain.models.Mission
import com.gg.spora.missions.domain.repository.IMissionRepositoryLocal
import javax.inject.Inject

class UpdateMissionByIdUseCase @Inject constructor(
    private val missionRepositoryLocal: IMissionRepositoryLocal
) {
    suspend operator fun invoke(
        missionId: Byte,
    ): Mission? {

        val missionLocal = missionRepositoryLocal.getMissionById(missionId)

        Log.i("titi", "missionLocal: $missionLocal")

        missionLocal?.let {
            if (!missionLocal.isCompleted) {
                missionRepositoryLocal.updateCounterMission(missionId)
            }
        }

        val missionLocalUpdated = missionRepositoryLocal.getMissionById(missionId)

        missionLocalUpdated?.let {
            if (missionLocalUpdated.isCompleted) {
                return missionLocalUpdated
            }
        }

        return null
    }
}