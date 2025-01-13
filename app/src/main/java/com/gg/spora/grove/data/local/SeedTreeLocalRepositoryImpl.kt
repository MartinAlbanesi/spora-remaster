package com.gg.spora.grove.data.local

import com.gg.spora.grove.data.database.dao.GroveDao
import com.gg.spora.grove.data.database.entities.toCooldownData
import com.gg.spora.grove.data.database.entities.toSeedTree
import com.gg.spora.grove.domain.interfaces.ISeedTreeRepositoryLocal
import com.gg.spora.grove.domain.mappers.toSeedTreeEntity
import com.gg.spora.grove.domain.models.CooldownData
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.toCooldownDataEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SeedTreeRepositoryLocalImpl @Inject constructor(
    private val groveDao: GroveDao
) : ISeedTreeRepositoryLocal {

    // Seed Trees

    // Inserts all seed trees into the database
    override suspend fun insertSeedTreesList(seedTrees: List<SeedTree>) {
        val seedTreeEntities = seedTrees.map { it.toSeedTreeEntity() }
        groveDao.insertSeedTreesList(seedTreeEntities)
    }

    // Inserts a seed tree into the database
    override suspend fun insertSeedTree(seedTree: SeedTree) {
        val seedTreeEntity = seedTree.toSeedTreeEntity()
        groveDao.insertSeedTree(seedTreeEntity)
    }

    // Gets all seed trees from the database
    override suspend fun getSeedTreesListFromDatabase(): Flow<List<SeedTree>> {
        return groveDao.getSeedTreesList().map {
            it.map { seedTreeEntity -> seedTreeEntity.toSeedTree() }
        }
    }

    // Deletes a seed tree by id
    override suspend fun deleteSeedTreeById(treeId: String) {
        groveDao.deleteSeedTreeById(treeId)
    }

    // Inserts cooldown data for a tree
    override suspend fun insertCooldownData(cooldownData: CooldownData) {
        groveDao.insertCooldownData(cooldownData.toCooldownDataEntity())
    }

    // Gets cooldown data for a tree
    override suspend fun getCooldownData(treeId: String): Flow<CooldownData> {
        return groveDao.getCooldownData(treeId).map { it?.toCooldownData() ?: CooldownData(treeId) }
    }
}