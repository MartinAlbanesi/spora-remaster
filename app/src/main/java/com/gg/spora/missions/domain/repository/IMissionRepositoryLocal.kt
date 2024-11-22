package com.gg.spora.missions.domain.repository

import com.gg.spora.missions.domain.models.Mission
import kotlinx.coroutines.flow.Flow

interface IMissionRepositoryLocal {

    fun getMissions(): Flow<List<Mission>>

    suspend fun getMissionById(id: Byte): Mission?

    suspend fun updateMission(mission: Mission)

    suspend fun updateCounterMission(id: Byte)

    suspend fun insertMissions(missions: List<Mission>)

    suspend fun claimMission(id: Byte)

    suspend fun deleteAllMissions()

    suspend fun clearMissions()
}