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
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForestTrees(forestTrees: List<ForestTreeEntity>)

    @Query("SELECT * FROM forest_trees")
    fun getForestTrees(): Flow<List<ForestTreeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeedTrees(seedTrees: List<SeedTreeEntity>)

    @Query("SELECT * FROM seed_trees")
    fun getSeedTrees(): Flow<List<SeedTreeEntity>>
}