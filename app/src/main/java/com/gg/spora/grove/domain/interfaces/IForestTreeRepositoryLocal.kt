package com.gg.spora.grove.domain.interfaces

import com.gg.spora.grove.domain.models.ForestTree
import kotlinx.coroutines.flow.Flow

interface IForestTreeRepositoryLocal {
    suspend fun getForestTreesListFromDatabase(): Flow<List<ForestTree?>>
    suspend fun getForestTreesExistsFromDatabase(): Flow<List<ForestTree>>
    suspend fun insertForestTree(forestTree: ForestTree)
    suspend fun updateForestTreeGrowthStage(forestTree: ForestTree)
    suspend fun deleteForestTreeById(treeId: String)
    suspend fun updateTimesOxygenClaimed(forestTree: ForestTree)
}