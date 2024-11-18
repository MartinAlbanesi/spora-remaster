package com.gg.spora.grove.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.gg.spora.grove.data.database.dao.GroveDao
import com.gg.spora.grove.data.database.entities.toCooldownData
import com.gg.spora.grove.data.database.entities.toForestTree
import com.gg.spora.grove.data.database.entities.toSeedTree
import com.gg.spora.grove.domain.models.CooldownData
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.toCooldownDataEntity
import com.gg.spora.grove.domain.models.toForestTreeEntity
import com.gg.spora.grove.domain.models.toSeedTreeEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Repository for managing seed trees, forest trees and cooldown data.
 * @param groveDao The DAO for accessing the Grove database.
 * @see IGroveRepository
 * @see GroveDao
 */
@RequiresApi(Build.VERSION_CODES.O)
class GroveRepository @Inject constructor(
    private val groveDao: GroveDao
) : IGroveRepository {

    // Seed Trees

    // Inserts all seed trees into the database
    override suspend fun insertSeedTreesList(seedTrees: List<SeedTree>) {
        val seedTreeEntities = seedTrees.map { it.toSeedTreeEntity() }
        groveDao.insertSeedTreesList(seedTreeEntities)
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

    // Forest Trees

    // Inserts a forest tree into the database
    override suspend fun insertForestTree(forestTree: ForestTree) {
        val forestTreeEntity = forestTree.toForestTreeEntity()
        groveDao.insertForestTree(forestTreeEntity)
    }

    // Gets all forest trees from the database
    override suspend fun getForestTreesListFromDatabase(): Flow<List<ForestTree?>> {
        return groveDao.getForestTreesList().map { forestTreeEntities ->
            val forestTrees = MutableList<ForestTree?>(50) { null } // Creates a list of 50 null elements
            forestTreeEntities.forEach { entity ->
                forestTrees[entity.position] = entity.toForestTree() // Places the forest tree in the list
            }
            forestTrees // Returns the list of forest trees with forest trees and null elements
        }
    }

    // Deletes a forest tree by id
    override suspend fun deleteForestTreeById(treeId: String) {
        groveDao.deleteForestTreeById(treeId)
    }

    // Growth Stage

    // Updates the growth stage of a forest tree
    override suspend fun updateForestTreeGrowthStage(forestTree: ForestTree) {
        groveDao.updateForestTreeGrowthStageById(forestTree.id, forestTree.currentStage.toString())
    }

    // Cooldown Data

    // Inserts cooldown data for a tree
    override suspend fun insertCooldownData(cooldownData: CooldownData) {
        groveDao.insertCooldownData(cooldownData.toCooldownDataEntity())
    }

    // Gets cooldown data for a tree
    override suspend fun getCooldownData(treeId: String): Flow<CooldownData> {
        return groveDao.getCooldownData(treeId).map { it?.toCooldownData() ?: CooldownData(treeId) }
    }
}