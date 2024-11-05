package com.gg.spora.grove.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gg.spora.grove.data.database.entities.ForestTreeEntity
import com.gg.spora.grove.data.database.entities.SeedTreeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GroveDao {

    @Query("SELECT * FROM seed_trees")
    fun getSeedTrees(): Flow<List<SeedTreeEntity>>

    @Query("SELECT * FROM forest_trees")
    fun getForestTrees(): Flow<List<ForestTreeEntity>>

    @Query("SELECT * FROM seed_trees WHERE idSeedTree = :id")
    fun getSeedTreeById(id: Int): Flow<SeedTreeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeedTrees(seedTrees: List<SeedTreeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForestTree(forestTree: ForestTreeEntity)

    @Query("DELETE FROM forest_trees")
    fun deleteAllForestTrees()

    @Query("UPDATE forest_trees SET current_stage = :newStage WHERE idForestTree = :id")
    suspend fun updateForestTreeGrowthStageById(id: Int, newStage: String)
}