package com.gg.spora.forestStage.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gg.spora.forestStage.data.local.models.LevelEntity
import com.gg.spora.forestStage.data.local.models.StageLevelEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StageDao {

    // --- LEVEL ---
    @Insert
    suspend fun insertLevels(levels: List<LevelEntity>)

    @Query("SELECT COUNT(*) FROM level_entity")
    suspend fun getLevelsCount(): Int

    @Query("SELECT * FROM level_entity where stageType = :stageType")
    fun getLevelsByStageType(stageType: String): Flow<List<LevelEntity>>

    // --- STAGE ---
    @Insert
    suspend fun insertStages(stages: List<StageLevelEntity>)

    @Query("SELECT * FROM stage_level WHERE stageType = :stageType LIMIT 1")
    suspend fun getStagesByStageType(stageType: String): StageLevelEntity?

    @Query("SELECT COUNT(*) FROM stage_level")
    suspend fun getStagesCount(): Int
}