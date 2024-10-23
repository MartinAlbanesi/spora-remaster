package com.gg.spora.grove.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gg.spora.grove.data.database.entities.ForestTreeEntity
import com.gg.spora.grove.data.database.entities.SeedTreeEntity

@Dao
interface GroveDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForestTrees(forestTrees: List<ForestTreeEntity>)

    @Query("SELECT * FROM forest_trees")
    suspend fun getForestTrees(): List<ForestTreeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeedTrees(seedTrees: List<SeedTreeEntity>)

    @Query("SELECT * FROM seed_trees")
    suspend fun getSeedTrees(): List<SeedTreeEntity>
}