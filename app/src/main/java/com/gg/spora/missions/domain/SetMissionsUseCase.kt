package com.gg.spora.missions.domain

import com.gg.spora.missions.domain.models.Mission
import com.gg.spora.missions.domain.repository.IMissionRepositoryLocal
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class SetMissionsUseCase @Inject constructor(
    private val missionRepositoryLocal: IMissionRepositoryLocal
) {
    suspend operator fun invoke(missions: List<Mission>) {

        val missionsLocal = missionRepositoryLocal.getMissions().first()

        if(missionsLocal.isNotEmpty()){
            return
        }

        missionRepositoryLocal.insertMissions(missions)
    }
}