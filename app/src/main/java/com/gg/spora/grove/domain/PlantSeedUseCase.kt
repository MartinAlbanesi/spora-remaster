package com.gg.spora.grove.domain

import android.util.Log
import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.TreeType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

// Caso de uso para plantar una semilla
class PlantSeedUseCase(private val groveRepository: IGroveRepository) {

    /**
     * Planta una semilla en un árbol del bosque.
     * @param type El tipo de árbol que se va a plantar.
     */
    operator fun invoke(type: TreeType): Flow<Pair<Int, Int>?> = flow {
        Log.d("GroveRepositoryImpl", "plantSeed called with seed: $type")

        val forest = groveRepository.loadForestTreesFromDatabase().first() // Obtener el bosque actual
        // 1. Encuentra un lugar vacío en el bosque
        val emptySpots = forest.flatMapIndexed { row, cols ->
            cols.mapIndexedNotNull { col, tree ->
                if (tree == null) Pair(row, col) else null
            }
        }

        // 2. Si no encontró ningún lugar vacío, retorna null
        if (emptySpots.isEmpty()) {
            emit(null)
            return@flow
        }

        // 3. Planta la semilla en un lugar aleatorio
        val (randomRow, randomCol) = emptySpots.random()
        val newTree = ForestTree(type = type)

        // 4. Actualiza la arboleda con el nuevo árbol
        val updatedForest = forest.mapIndexed { row, cols ->
            if (row == randomRow) {
                cols.mapIndexed { col, tree ->
                    if (col == randomCol) newTree else tree
                }
            } else cols
        }

        // 5. Save the updated forest to the database
        groveRepository.saveForestTrees(updatedForest)

        Log.d("GroveRepositoryImpl", "New tree planted: $newTree")
        Log.d("GroveRepositoryImpl", "Updated forest: $updatedForest")

        // 6. Emit the position of the new tree
        emit(Pair(randomRow, randomCol))
    }
}