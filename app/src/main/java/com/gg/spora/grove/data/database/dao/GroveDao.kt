package com.gg.spora.grove.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gg.spora.grove.data.database.entities.CooldownDataEntity
import com.gg.spora.grove.data.database.entities.ForestTreeEntity
import com.gg.spora.grove.data.database.entities.SeedTreeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GroveDao {

    // Seed Trees
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeedTreesList(seedTrees: List<SeedTreeEntity>)

    @Query("SELECT * FROM seed_trees")
    fun getSeedTreesList(): Flow<List<SeedTreeEntity>>

    @Query("SELECT * FROM seed_trees WHERE idSeedTree = :id")
    fun getSeedTreeById(id: String): Flow<SeedTreeEntity>

    @Query("DELETE FROM seed_trees WHERE idSeedTree = :treeId")
    suspend fun deleteSeedTreeById(treeId: String)

    // Forest Trees
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForestTree(forestTree: ForestTreeEntity)

    @Query("SELECT * FROM forest_trees")
    fun getForestTreesList(): Flow<List<ForestTreeEntity>>

    @Query("DELETE FROM forest_trees WHERE idForestTree = :treeId")
    suspend fun deleteForestTreeById(treeId: String)

    @Query("DELETE FROM forest_trees")
    fun deleteAllForestTrees()

    // Growth Stage
    @Query("UPDATE forest_trees SET current_stage = :newStage WHERE idForestTree = :id")
    suspend fun updateForestTreeGrowthStageById(id: String, newStage: String)

    // Cooldown Data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCooldownData(cooldownData: CooldownDataEntity)

    @Query("SELECT * FROM cooldown_data WHERE treeId = :treeId")
    fun getCooldownData(treeId: String): Flow<CooldownDataEntity?>
}