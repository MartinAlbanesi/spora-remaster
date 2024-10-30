package com.gg.spora.grove.data

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.gg.spora.grove.data.database.dao.GroveDao
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.time.Duration

/**
 * Clase GroveRepository que implementa la interfaz IGroveRepository para interactuar con los árboles del bosque, generando semillas y recolectando oxígeno.
 */
@RequiresApi(Build.VERSION_CODES.O)
class GroveRepository(
    private val groveDao: GroveDao
) : IGroveRepository {

    // MutableStateFlow para los árboles semilleros
    private val _seedTrees = MutableStateFlow<List<SeedTree>>(emptyList())

    // MutableStateFlow para los árboles del bosque
    private val _forestTrees = MutableStateFlow<List<ForestTree?>>(emptyList())

    /*
        init {

            // Inicializa con árboles semilleros de ejemplo
            _seedTrees.value = listOf(
                SeedTree(type = TreeType.BAOBAB, timeToGenerateForestTree = Duration.ofSeconds(5)),
                SeedTree(type = TreeType.SECUOYA, timeToGenerateForestTree = Duration.ofSeconds(5)),
                SeedTree(type = TreeType.PINE, timeToGenerateForestTree = Duration.ofSeconds(5))
            )

            // Inicializa con 5 filas y 5 columnas de árboles del bosque vacíos
            _forestTrees.value = List(5) { MutableList<ForestTree?>(5) { null } }
        }
    */
    init {
        CoroutineScope(Dispatchers.IO).launch {
            // Load existing seed trees from the database
            loadSeedTreesFromDatabase().collect { seedTrees ->
                _seedTrees.value = seedTrees
                Log.i("GroveRepository", "Loaded seed trees: $seedTrees")

                // If the database is empty, insert 3 seed trees
                if (seedTrees.isEmpty()) {
                    val initialSeedTrees = listOf(
                        SeedTree(
                            type = TreeType.BAOBAB,
                            timeToGenerateForestTree = Duration.ofSeconds(5)
                        ),
                        SeedTree(
                            type = TreeType.SECUOYA,
                            timeToGenerateForestTree = Duration.ofSeconds(5)
                        ),
                        SeedTree(
                            type = TreeType.PINE,
                            timeToGenerateForestTree = Duration.ofSeconds(5)
                        )
                    )
                    saveSeedTrees(initialSeedTrees)
                    Log.i("GroveRepository", "Inserted initial seed trees: $initialSeedTrees")
                }
            }
            loadForestTreesFromDatabase().collect { forestTrees ->
                _forestTrees.value = forestTrees
            }
        }
    }

    /*
        // Devuelve los árboles semilleros
        override fun getSeedTrees(): Flow<List<SeedTree>> = _seedTrees.asStateFlow()

        // Devuelve los árboles del bosque
        override fun getForestTrees(): Flow<List<List<ForestTree?>>> = _forestTrees.asStateFlow()
     */

    override suspend fun saveForestTrees(forest: List<ForestTree?>) {
        val forestTreeEntities = forest.filterNotNull().map { it.toForestTreeEntity() }
        groveDao.insertForestTrees(forestTreeEntities)
    }

    override suspend fun loadForestTreesFromDatabase(): Flow<List<ForestTree?>> = flow {
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
    }

    override suspend fun saveSeedTrees(seedTrees: List<SeedTree>) {
        val seedTreeEntities = seedTrees.map { it.toSeedTreeEntity() }
        groveDao.insertSeedTrees(seedTreeEntities)
    }

    override suspend fun loadSeedTreesFromDatabase(): Flow<List<SeedTree>> = flow {
        emit(SeedTree.seedTreesEntitiesToModels(groveDao.getSeedTrees()))
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