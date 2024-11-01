package com.gg.spora.grove.data

import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree
import kotlinx.coroutines.flow.Flow

interface IGroveRepository {
    /*
    fun getSeedTrees(): Flow<List<SeedTree>>
    fun getForestTrees(): Flow<List<List<ForestTree?>>>
     */
    suspend fun collectOxygen(): Int
    suspend fun saveSeedTrees(seedTrees: List<SeedTree>)
    suspend fun loadSeedTreesFromDatabase(): Flow<List<SeedTree>>
    suspend fun saveForestTrees(forest: List<ForestTree?>)
    suspend fun loadForestTreesFromDatabase(): Flow<List<ForestTree?>>
    suspend fun insertForestTree(forestTree: ForestTree)
    suspend fun getForestTreeById(id: Int): Flow<ForestTree?>
}