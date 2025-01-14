package com.gg.spora.grove.domain.interfaces

import com.gg.spora.grove.domain.models.CooldownData
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree
import kotlinx.coroutines.flow.Flow

/**
 * Interface for the Grove repository.
 * @see GroveRepository
 */
interface IGroveRepository {
    suspend fun getSeedTreesListFromDatabase(): Flow<List<SeedTree>>
    suspend fun getForestTreesListFromDatabase(): Flow<List<ForestTree?>>
    suspend fun getForestTreesExistsFromDatabase(): Flow<List<ForestTree>>
    suspend fun insertSeedTreesList(seedTrees: List<SeedTree>)
    suspend fun insertSeedTree(seedTree: SeedTree)
    suspend fun insertForestTree(forestTree: ForestTree)
    suspend fun updateForestTreeGrowthStage(forestTree: ForestTree)
    suspend fun insertCooldownData(cooldownData: CooldownData)
    suspend fun getCooldownData(treeId: String): Flow<CooldownData>
    suspend fun deleteSeedTreeById(treeId: String)
    suspend fun deleteForestTreeById(treeId: String)
    suspend fun updateTimesOxygenClaimed(forestTree: ForestTree)
}