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
 * Clase GroveRepository que implementa la interfaz IGroveRepository para interactuar con los árboles del bosque, generando semillas y recolectando oxígeno.
 */
@RequiresApi(Build.VERSION_CODES.O)
class GroveRepository @Inject constructor(
    private val groveDao: GroveDao
) : IGroveRepository {

    // Carga los árboles semilleros desde la base de datos
    override suspend fun getSeedTreesFromDatabase(): Flow<List<SeedTree>> {
        return groveDao.getSeedTrees().map {
            it.map { seedTreeEntity -> seedTreeEntity.toSeedTree() }
        }
    }

    // Carga los árboles del bosque desde la base de datos
    override suspend fun getForestTreesFromDatabase(): Flow<List<ForestTree?>> {
        return groveDao.getForestTrees().map { forestTreeEntities ->
            val forestTrees = MutableList<ForestTree?>(25) { null } // Inicializa con 25 espacios nulos
            forestTreeEntities.forEach { entity ->
                forestTrees[entity.position] =
                    entity.toForestTree() // Coloca el árbol en su posición correspondiente
            }
            forestTrees // Retorna la lista completa de árboles del bosque
        }
    }

    // Guarda los árboles semilleros en la base de datos
    override suspend fun insertAllSeedTrees(seedTrees: List<SeedTree>) {
        val seedTreeEntities = seedTrees.map { it.toSeedTreeEntity() }
        groveDao.insertSeedTrees(seedTreeEntities)
    }

    // Inserta un árbol de bosque en la base de datos
    override suspend fun insertForestTree(forestTree: ForestTree) {
        val forestTreeEntity = forestTree.toForestTreeEntity()
        groveDao.insertForestTree(forestTreeEntity)
    }

    override suspend fun updateForestTreeGrowthStage(forestTree: ForestTree) {
        groveDao.updateForestTreeGrowthStageById(forestTree.id, forestTree.currentStage.toString())
    }

    override suspend fun getCooldownData(treeId: String): Flow<CooldownData> {
        return groveDao.getCooldownData(treeId).map { it?.toCooldownData() ?: CooldownData(treeId) }
    }

    override suspend fun insertCooldownData(cooldownData: CooldownData) {
        groveDao.insertCooldownData(cooldownData.toCooldownDataEntity())
    }
}