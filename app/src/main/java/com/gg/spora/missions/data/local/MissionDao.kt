package com.gg.spora.missions.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MissionDao {

    @Query("SELECT * FROM missions")
    fun getMissions(): Flow<List<MissionEntity>>

    @Query("SELECT * FROM missions WHERE id = :id")
    suspend fun getMissionById(id: Byte): MissionEntity?

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateMission(mission: MissionEntity)

    @Query("UPDATE missions SET counter = counter + 1 WHERE id = :id")
    suspend fun updateCounterMission(id: Byte)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMission(mission: MissionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMissions(missions: List<MissionEntity>)
}