package com.gg.spora.grove.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.gg.spora.grove.data.database.dao.GroveDao
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Clase GroveRepository que implementa la interfaz IGroveRepository para interactuar con los árboles del bosque, generando semillas y recolectando oxígeno.
 */
@RequiresApi(Build.VERSION_CODES.O)
class GroveRepository(
    private val groveDao: GroveDao
) : IGroveRepository {

    override suspend fun saveForestTrees(forest: List<ForestTree?>) {
        val forestTreeEntities = forest.filterNotNull().map { it.toForestTreeEntity() }
        groveDao.insertForestTrees(forestTreeEntities)
    }

    override suspend fun loadForestTreesFromDatabase(): Flow<List<ForestTree?>> {

        return groveDao.getForestTrees().map { ForestTree.forestTreesEntitiesToModels(it) }

        /*
        val forestTrees = ForestTree.forestTreesEntitiesToModels(groveDao.getForestTrees())

        // Crea una lista mutable para almacenar los objetos ForestTree
        val forestList = mutableListOf<ForestTree?>()

        // Agrega los objetos ForestTree a la lista
        forestTrees.forEach { forestTree ->
            forestList.add(forestTree)
        }

        // Completa la lista con objetos null hasta completar 25 elementos (tamaño de una matriz 5x5)
        while (forestList.size < 25) {
            forestList.add(null)
        }

        emit(forestList)
         */
    }

    override suspend fun saveSeedTrees(seedTrees: List<SeedTree>) {
        val seedTreeEntities = seedTrees.map { it.toSeedTreeEntity() }
        groveDao.insertSeedTrees(seedTreeEntities)
    }

    override suspend fun loadSeedTreesFromDatabase(): Flow<List<SeedTree>> {
        // return SeedTree.seedTreesEntitiesToModels(groveDao.getSeedTrees())
        return groveDao.getSeedTrees().map { SeedTree.seedTreesEntitiesToModels(it) }
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