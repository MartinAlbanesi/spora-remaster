package com.gg.spora.missions.domain.repository

import com.gg.spora.missions.domain.models.Mission
import kotlinx.coroutines.flow.Flow

interface MissionRepositoryLocal {

    fun getMissions(): Flow<List<Mission>>

    fun getMissionById(id: Byte): Mission?

    fun updateMission(mission: Mission)
}