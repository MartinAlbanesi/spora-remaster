package com.gg.spora.grove.domain.interfaces

import com.gg.spora.grove.domain.models.CooldownData
import com.gg.spora.grove.domain.models.SeedTree
import kotlinx.coroutines.flow.Flow

interface ISeedTreeRepositoryLocal {

    suspend fun getSeedTreesListFromDatabase(): Flow<List<SeedTree>>
    suspend fun insertSeedTreesList(seedTrees: List<SeedTree>)
    suspend fun insertSeedTree(seedTree: SeedTree)
    suspend fun deleteSeedTreeById(treeId: String)
    suspend fun insertCooldownData(cooldownData: CooldownData)
    suspend fun getCooldownData(treeId: String): Flow<CooldownData>
}