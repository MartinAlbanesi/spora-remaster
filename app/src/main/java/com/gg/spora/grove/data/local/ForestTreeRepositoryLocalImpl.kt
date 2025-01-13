package com.gg.spora.grove.data.local

import com.gg.spora.grove.data.database.dao.GroveDao
import com.gg.spora.grove.domain.interfaces.IForestTreeRepositoryLocal
import com.gg.spora.grove.domain.mappers.toForestList
import com.gg.spora.grove.domain.mappers.toForestTree
import com.gg.spora.grove.domain.mappers.toForestTreeEntity
import com.gg.spora.grove.domain.models.ForestTree
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ForestTreeRepositoryLocalImpl @Inject constructor(
    private val groveDao: GroveDao
) : IForestTreeRepositoryLocal {

    // Inserts a forest tree into the database
    override suspend fun insertForestTree(forestTree: ForestTree) {
        val forestTreeEntity = forestTree.toForestTreeEntity()
        groveDao.insertForestTree(forestTreeEntity)
    }

    // Gets all forest trees from the database and list empty
    override suspend fun getForestTreesListFromDatabase(): Flow<List<ForestTree?>> {
        return groveDao.getForestTreesList().map { forestTreeEntities ->
            val forestTrees =
                MutableList<ForestTree?>(50) { null } // Creates a list of 50 null elements
            forestTreeEntities.forEach { entity ->
                forestTrees[entity.position] =
                    entity.toForestTree() // Places the forest tree in the list
            }
            forestTrees // Returns the list of forest trees with forest trees and null elements
        }
    }

    // Gets all forest trees from the database
    override suspend fun getForestTreesExistsFromDatabase(): Flow<List<ForestTree>> {
        return groveDao.getForestTreesList().map { it.toForestList() }
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

    override suspend fun updateTimesOxygenClaimed(forestTree: ForestTree) {
        groveDao.updateTimesOxygenClaimed(forestTree.id, forestTree.timesOxygenClaimed)
    }

}