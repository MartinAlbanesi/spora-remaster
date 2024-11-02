package com.gg.spora.grove.data

import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree
import kotlinx.coroutines.flow.Flow

interface IGroveRepository {
    suspend fun getSeedTreesFromDatabase(): Flow<List<SeedTree>>
    suspend fun getForestTreesFromDatabase(): Flow<List<ForestTree?>>
    suspend fun getForestTreeById(id: Int): Flow<ForestTree?>
    suspend fun insertAllSeedTrees(seedTrees: List<SeedTree>)
    suspend fun insertAllForestTrees(forest: List<ForestTree?>)
    suspend fun insertForestTree(forestTree: ForestTree)
    suspend fun collectOxygen(): Int
}