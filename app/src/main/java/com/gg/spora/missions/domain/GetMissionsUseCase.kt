package com.gg.spora.missions.domain

import com.gg.spora.missions.domain.models.Mission
import com.gg.spora.missions.domain.repository.IMissionRepositoryLocal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMissionsUseCase @Inject constructor(
    private val missionRepositoryLocal: IMissionRepositoryLocal
) {
    operator fun invoke(): Flow<List<Mission>> {
        return missionRepositoryLocal.getMissions()
    }
}