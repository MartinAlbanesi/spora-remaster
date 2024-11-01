package com.gg.spora.grove.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.grove.domain.GetForestTreeByIdUseCase
import com.gg.spora.grove.domain.InsertForestTreeUseCase
import com.gg.spora.grove.domain.LoadForestTreesUseCase
import com.gg.spora.grove.domain.LoadSeedTreesUseCase
import com.gg.spora.grove.domain.SaveForestTreesUseCase
import com.gg.spora.grove.domain.SaveSeedTreesUseCase
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalDateTime
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
    // private val getSeedTreesUseCase: GetSeedTreesUseCase,
    // private val getForestTreesUseCase: GetForestTreesUseCase,
    // private val plantSeedUseCase: PlantSeedUseCase,
    private val loadSeedTreesUseCase: LoadSeedTreesUseCase,
    private val saveSeedTreesUseCase: SaveSeedTreesUseCase,
    private val loadForestTreesUseCase: LoadForestTreesUseCase,
    private val saveForestTreesUseCase: SaveForestTreesUseCase,
    private val getForestTreeByIdUseCase: GetForestTreeByIdUseCase,
    private val insertForestTreeUseCase: InsertForestTreeUseCase,
) : ViewModel() {

    // State para los árboles semilleros y los árboles del bosque
    private val _seedTrees = MutableStateFlow<List<SeedTree>>(emptyList())
    val seedTrees: StateFlow<List<SeedTree>> = _seedTrees.asStateFlow()

    private val _forestTrees = MutableStateFlow<List<ForestTree?>>(emptyList())
    val forestTrees: StateFlow<List<ForestTree?>> = _forestTrees.asStateFlow()

    private val _forestTree = MutableStateFlow<ForestTree?>(null)
    val forestTree = _forestTree.asStateFlow()

    // Inicialización de los casos de uso
    init {
//        getForestTrees()
        getSeedTrees()
        getForestTrees()
        initSeedTrees()
        initForestTrees()
//        initForestTrees()
    }

    private fun initSeedTrees() {
        viewModelScope.launch(Dispatchers.IO) {

            // Tiempo necesario para que se carguen los árboles semilleros
            delay(500)

            if (_seedTrees.value.isEmpty()) {
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
                        type = TreeType.MANGROVE,
                        timeToGenerateForestTree = Duration.ofSeconds(5)
                    ),
                    )
                saveSeedTreesUseCase(initialSeedTrees)
            }
        }
    }

    private fun initForestTrees() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)

            Log.i("GroveViewModel", "BEFORE ForestTrees: ${_forestTrees.value}")

            if (_forestTrees.value.isEmpty()) {
                val initialForestTrees = List(25) { null }
                saveForestTreesUseCase(initialForestTrees)
                Log.i("GroveViewModel", "AFTER ForestTrees: ${_forestTrees.value}")
            }
        }
    }

    fun getSeedTrees() {
        viewModelScope.launch(Dispatchers.IO) {
            loadSeedTreesUseCase().collect {
                _seedTrees.value = it
            }
        }
    }

    fun getForestTrees() {
        viewModelScope.launch(Dispatchers.IO) {
            loadForestTreesUseCase().collect {
                _forestTrees.value = it
            }
        }
    }

    fun saveSeedTrees() {
        viewModelScope.launch(Dispatchers.IO) {
            saveSeedTreesUseCase(_seedTrees.value)
        }
    }

    fun saveForestTrees() {
        viewModelScope.launch {
            saveForestTreesUseCase(_forestTrees.value)
        }
    }

    // Plantar una semilla en el bosque
    fun plantSeedInForest(type: TreeType) {
        viewModelScope.launch(Dispatchers.IO) {
            // Encuentra un lugar vacío en el bosque
            val emptySpots = _forestTrees.value.withIndex().filter { it.value == null }.map { it.index }

            // Si no encontró ningún lugar vacío, retorna
            if (emptySpots.isEmpty()) {
                return@launch
            }

            // Dentro de los lugares vacíos, busca un lugar aleatorio
            val randomIndex = emptySpots.random()
            val newTree = ForestTree(type = type, plantingDate = LocalDateTime.now()) // Initialize plantingDate

            // Actualiza la arboleda con el nuevo árbol (immutable update)
            val updatedForest = _forestTrees.value.toMutableList()
            updatedForest[randomIndex] = newTree
            _forestTrees.value = updatedForest.toList() // Assign the new list to _forestTrees.value

            saveForestTreesUseCase(_forestTrees.value)
        }
    }

    // Actualización del estado del árbol
    fun updateTree(updatedTree: ForestTree) {
        val updatedForest = _forestTrees.value.map { tree ->
            if (tree != null && tree.id == updatedTree.id) { // Verifica que el árbol no sea nulo y que su ID coincida
                updatedTree
            } else {
                tree
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
