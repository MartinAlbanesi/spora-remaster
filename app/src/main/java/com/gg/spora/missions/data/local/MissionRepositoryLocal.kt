package com.gg.spora.missions.data.local

import com.gg.spora.missions.domain.mappers.toMission
import com.gg.spora.missions.domain.mappers.toMissionEntity
import com.gg.spora.missions.domain.models.Mission
import com.gg.spora.missions.domain.repository.IMissionRepositoryLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MissionRepositoryLocal @Inject constructor(
    private val missionDao: MissionDao
): IMissionRepositoryLocal{
    override fun getMissions(): Flow<List<Mission>> {
        return missionDao.getMissions().map { missions ->
            missions.map { it.toMission() }
        }
    }

    override suspend fun getMissionById(id: Byte): Mission? {
        return missionDao.getMissionById(id)?.toMission()
    }

    override suspend fun updateMission(mission: Mission) {
        missionDao.updateMission(mission.toMissionEntity())
    }

    override suspend fun updateCounterMission(id: Byte) {
        missionDao.updateCounterMission(id)
    }

    override suspend fun insertMissions(missions: List<Mission>) {
        missionDao.insertMissions(missions.map { it.toMissionEntity() })
    }

    override suspend fun claimMission(id: Byte) {
        missionDao.claimMission(id)
    }
}