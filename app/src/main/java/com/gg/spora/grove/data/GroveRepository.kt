package com.gg.spora.grove.data

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.gg.spora.grove.data.models.ForestTree
import com.gg.spora.grove.data.models.GrowthStage
import com.gg.spora.grove.data.models.Seed
import com.gg.spora.grove.data.models.SeedTree
import com.gg.spora.grove.data.models.TreeType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.Duration

/**
 * Clase GroveRepository que implementa la interfaz IGroveRepository para interactuar con los árboles del bosque, generando semillas y recolectando oxígeno.
 */
@RequiresApi(Build.VERSION_CODES.O)
class GroveRepository : IGroveRepository {

    // MutableStateFlow para los árboles semilleros
    private val _seedTrees = MutableStateFlow<List<SeedTree>>(emptyList())
    // MutableStateFlow para los árboles del bosque
    private val _forestTrees = MutableStateFlow<List<List<ForestTree?>>>(emptyList())

    init {
        // Inicializa con árboles semilleros de ejemplo
        _seedTrees.value = listOf(
            SeedTree(type = TreeType.MANGROVE, timeToGenerateSeed = Duration.ofSeconds(5)),
            SeedTree(type = TreeType.SECUOYA, timeToGenerateSeed = Duration.ofSeconds(5))
        )

        // Inicializa con 5 filas y 5 columnas de árboles del bosque vacíos
        _forestTrees.value = List(5) { MutableList<ForestTree?>(5) { null } }
    }

    // Devuelve los árboles semilleros
    override fun getSeedTrees(): Flow<List<SeedTree>> = _seedTrees.asStateFlow()

    // Devuelve los árboles del bosque
    override fun getForestTrees(): Flow<List<List<ForestTree?>>> = _forestTrees.asStateFlow()

    /**
     * Planta una semilla en un árbol del bosque.
     * @param seed La semilla a plantar.
     */
    override suspend fun plantSeed(seed: Seed): ForestTree? {

        Log.d("GroveRepositoryImpl", "plantSeed called with seed: $seed")

        // 1. Encuentra un lugar vacío en el bosque
        val emptySpots = mutableListOf<Pair<Int, Int>>()
        for (row in _forestTrees.value.indices) {
            for (col in _forestTrees.value[row].indices) {
                if (_forestTrees.value[row][col] == null) {
                    emptySpots.add(Pair(row, col))
                }
            }
        }

        // 2. Si no hay lugares vacíos, devuelve null
        if (emptySpots.isEmpty()) {
            // Opcional: Se puede lanzar una excepción aquí si no hay lugares vacíos
            return null
        }

        // 3. Si hay lugares vacíos, planta la semilla en uno de ellos
        while (emptySpots.isNotEmpty()) {

            // 4. Selecciona un lugar al azar
            val randomSpot = emptySpots.random()
            val randomRow = randomSpot.first
            val randomCol = randomSpot.second

            // 5. Verifica si el lugar está vacío
            if (_forestTrees.value[randomRow][randomCol] == null) {
                val newTree = ForestTree(type = seed.type)

                val updatedRow = _forestTrees.value[randomRow].toMutableList()
                updatedRow[randomCol] = newTree

                val updatedForest = _forestTrees.value.toMutableList()
                updatedForest[randomRow] = updatedRow

                // Actualiza el estado con el nuevo árbol
                _forestTrees.value = updatedForest

                Log.d("GroveRepositoryImpl", "New tree planted: $newTree")
                Log.d("GroveRepositoryImpl", "Updated forest: ${_forestTrees.value}")

                return newTree // 6. Retorna el arbol creado si se pudo plantar
            } else {
                // 7. Si el lugar no está vacío, elimina el lugar de la lista de lugares vacíos
                emptySpots.remove(randomSpot)
            }
        }

        return null // Si no se pudo plantar, devuelve null
    }

    // Recolecta el oxígeno de los árboles del bosque
    override suspend fun collectOxygen(): Int {
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
    }
}