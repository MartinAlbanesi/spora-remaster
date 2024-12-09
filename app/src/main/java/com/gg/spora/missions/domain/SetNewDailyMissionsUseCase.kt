package com.gg.spora.missions.domain

import com.gg.spora.core.utils.SporaConstant.MAX_DAILY_MISSIONS
import com.gg.spora.missions.data.local.MissionModels
import com.gg.spora.missions.domain.models.Mission
import com.gg.spora.missions.domain.repository.IMissionRepositoryLocal
import com.gg.spora.user.domain.functions.getResetDailyMissionTimeStamp
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import javax.inject.Inject

class SetNewDailyMissionsUseCase @Inject constructor(
    private val userRepositoryLocal: IUserRepositoryLocal,
    private val missionRepositoryLocal: IMissionRepositoryLocal,
//    private val missionRepositoryNetwork: IMissionRepositoryNetwork
) {
    suspend operator fun invoke(missions: List<Mission>) {
        missionRepositoryLocal.deleteAllMissions()
        userRepositoryLocal.updateResetDailyMission(getResetDailyMissionTimeStamp())
        missionRepositoryLocal.insertMissions(
            missions.shuffled().take(MAX_DAILY_MISSIONS) + MissionModels.missionAd
        )
    }
}