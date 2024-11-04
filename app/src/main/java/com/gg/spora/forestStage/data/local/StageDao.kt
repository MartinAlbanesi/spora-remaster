package com.gg.spora.forestStage.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gg.spora.forestStage.data.local.models.LevelEntity

@Dao
interface StageDao {

    @Insert
    fun insertLevels(levels: List<LevelEntity>)

    @Query("SELECT COUNT(*) FROM level_entity")
    fun getLevelsCount(): Int

    @Query("SELECT * FROM level_entity where stageType = :stageType")
    fun getLevels(stageType: String): List<LevelEntity>
}