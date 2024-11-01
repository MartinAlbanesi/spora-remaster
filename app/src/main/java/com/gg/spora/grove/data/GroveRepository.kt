package com.gg.spora.grove.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.gg.spora.grove.data.database.dao.GroveDao
import com.gg.spora.grove.data.database.entities.toForestTree
import com.gg.spora.grove.data.database.entities.toSeedTree
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.toForestTreeEntity
import com.gg.spora.grove.domain.models.toSeedTreeEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Clase GroveRepository que implementa la interfaz IGroveRepository para interactuar con los árboles del bosque, generando semillas y recolectando oxígeno.
 */
@RequiresApi(Build.VERSION_CODES.O)
class GroveRepository(
    private val groveDao: GroveDao
) : IGroveRepository {

    // Guarda los árboles semilleros en la base de datos
    override suspend fun saveSeedTrees(seedTrees: List<SeedTree>) {
        val seedTreeEntities = seedTrees.map { it.toSeedTreeEntity() }
        groveDao.insertSeedTrees(seedTreeEntities)
    }

    // Carga los árboles semilleros desde la base de datos
    override suspend fun loadSeedTreesFromDatabase(): Flow<List<SeedTree>> {
        // return SeedTree.seedTreesEntitiesToModels(groveDao.getSeedTrees())
        return groveDao.getSeedTrees().map {
//            SeedTree.seedTreesEntitiesToModels(it)
            it.map { seedTreeEntity -> seedTreeEntity.toSeedTree() }
        }
    }

    // Guarda los árboles del bosque en la base de datos
    override suspend fun saveForestTrees(forest: List<ForestTree?>) {
        val forestTreeEntities = forest.filterNotNull().map { it.toForestTreeEntity() }
        groveDao.insertForestTrees(forestTreeEntities)
    }

    // Carga los árboles del bosque desde la base de datos
    override suspend fun loadForestTreesFromDatabase(): Flow<List<ForestTree?>> {
        return groveDao.getForestTrees().map {
            it.map {
                forestTreeEntity -> forestTreeEntity.toForestTree()
            }
        }
    }

    // Inserta un árbol de bosque en la base de datos
    override suspend fun insertForestTree(forestTree: ForestTree){
        val forestTreeEntity = forestTree.toForestTreeEntity()
        groveDao.insertForestTree(forestTreeEntity)
    }

    // Carga un árbol del bosque por su ID desde la base de datos
    override suspend fun getForestTreeById(id: Int): Flow<ForestTree?> {
        return groveDao.getForestTreeById(id).map { it.toForestTree() }
    }

    // Recolecta el oxígeno de los árboles del bosque
    override suspend fun collectOxygen(): Int {
        /*
        var totalOxygen = 0

        // Recorre los árboles del bosque y recolecta el oxígeno de los árboles adultos
        for (row in _forestTrees.value) {
            for (tree in row) {
                if (tree != null && tree.currentStage == GrowthStage.ADULT) {
                    totalOxygen += tree.collectOxygen()
                }
            }
        }
        return totalOxygen

         */
        return 0
    }
}