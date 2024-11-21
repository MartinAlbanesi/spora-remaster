package com.gg.spora.missions.domain

import com.gg.spora.missions.domain.models.Mission
import com.gg.spora.missions.domain.repository.MissionRepositoryLocal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMissionsUseCase @Inject constructor(
    private val missionRepositoryLocal: MissionRepositoryLocal
) {
    operator fun invoke(): Flow<List<Mission>> {
        return missionRepositoryLocal.getMissions()
    }
}