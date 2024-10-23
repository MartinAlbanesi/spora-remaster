package com.gg.spora.grove.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.grove.domain.GetForestTreesUseCase
import com.gg.spora.grove.domain.GetSeedTreesUseCase
import com.gg.spora.grove.domain.PlantSeedUseCase
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel para la pantalla del grove.
 * @param getSeedTreesUseCase Caso de uso para obtener los árboles semilleros.
 * @param getForestTreesUseCase Caso de uso para obtener los árboles del bosque.
 * @param plantSeedUseCase Caso de uso para plantar una semilla.
 * @param collectOxygenUseCase Caso de uso para recolectar oxígeno.
 */
@HiltViewModel
class GroveViewModel @Inject constructor(
    private val getSeedTreesUseCase: GetSeedTreesUseCase,
    private val getForestTreesUseCase: GetForestTreesUseCase,
    private val plantSeedUseCase: PlantSeedUseCase,
    // private val collectOxygenUseCase: CollectOxygenUseCase
) : ViewModel() {

    // State para los árboles semilleros y los árboles del bosque
    private val _seedTrees = MutableStateFlow<List<SeedTree>>(emptyList())
    val seedTrees: StateFlow<List<SeedTree>> = _seedTrees.asStateFlow()

    private val _forestTrees = MutableStateFlow<List<List<ForestTree?>>>(emptyList())
    val forestTrees: StateFlow<List<List<ForestTree?>>> = _forestTrees.asStateFlow()

    private val _forestTree = MutableStateFlow<ForestTree?>(null)
    val forestTree = _forestTree.asStateFlow()

    // Inicialización de los casos de uso
    init {
        getSeedTrees()
        getForestTrees()
    }

    fun getSeedTrees() {
        viewModelScope.launch {
            getSeedTreesUseCase().collect { seedTrees ->
                _seedTrees.value = seedTrees
            }
        }
    }

    fun getForestTrees() {
        viewModelScope.launch {
            getForestTreesUseCase().collect { forestTrees ->
                _forestTrees.value = forestTrees
            }
        }
    }

    fun setInitialForest(forest: List<List<ForestTree?>>) {
        _forestTrees.value = forest
    }

    // Plantar una semilla en el bosque
    fun plantSeedInForest(type: TreeType) {
        viewModelScope.launch {
            _forestTree.value = plantSeedUseCase(type) // No need to store the result in currentTree
        }
    }

    // Actualización del estado del árbol
    fun updateTree(updatedTree: ForestTree) {
        val updatedForest = _forestTrees.value.mapIndexed { rowIndex, row ->
            row.mapIndexed { colIndex, tree ->
                if (tree != null && ForestTree == ForestTree) {
                    updatedTree
                } else {
                    tree
                }
            }
        }
        _forestTrees.value = updatedForest
    }

    /*
    fun collectOxygen() {
        viewModelScope.launch {
            val oxygen = collectOxygenUseCase() // Delegate to use case
            // Update UI or state with the collected oxygen
        }
    }
     */
}
