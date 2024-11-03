package com.gg.spora.grove.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.grove.domain.GetForestTreeByIdUseCase
import com.gg.spora.grove.domain.GetSeedTreeByIdUseCase
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
    private val getSeedTreeByIdUseCase: GetSeedTreeByIdUseCase,
//    private val updateForestTreeGrowthStageByIdUseCase: UpdateForestTreeGrowthStageByIdUseCase,
//    private val updateSeedCooldownUseCase: UpdateSeedCooldownUseCase,
) : ViewModel() {

    // State para los árboles semilleros y los árboles del bosque
    private val _seedTrees = MutableStateFlow<List<SeedTree>>(emptyList())
    val seedTrees: StateFlow<List<SeedTree>> = _seedTrees.asStateFlow()

    private val _forestTrees = MutableStateFlow<List<ForestTree?>>(emptyList())
    val forestTrees: StateFlow<List<ForestTree?>> = _forestTrees.asStateFlow()

//    private val _forestTree = MutableStateFlow<ForestTree?>(null)
//    val forestTree = _forestTree.asStateFlow()

    // Inicialización de los casos de uso
    init {
        getSeedTrees()
        getForestTrees()
        initSeedTrees()
        initForestTrees()
    }

    // Inicializa los árboles semilleros la primera vez que se abre la pantalla
    fun initSeedTrees() {
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
                // _seedTrees.value = initialSeedTrees
            }
        }
    }

    // Inicializa los árboles del bosque la primera vez que se abre la pantalla
    fun initForestTrees() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(500) // Optional delay

            if (_forestTrees.value.isEmpty()) {
                _forestTrees.value = MutableList<ForestTree?>(25) { null } // Initialize with 25 nulls
                Log.i("GroveViewModel", "ForestTrees initialized: ${_forestTrees.value}")
            }
        }
    }

    // Carga los árboles semilleros desde la base de datos
    fun getSeedTrees() {
        viewModelScope.launch(Dispatchers.IO) {
            loadSeedTreesUseCase().collect {
                _seedTrees.value = it
            }
        }
    }

    // Carga los árboles del bosque desde la base de datos para Test
    fun getForestTrees() {
        viewModelScope.launch(Dispatchers.IO) {
            loadForestTreesUseCase().collect {
                _forestTrees.value = it
            }
        }
    }

//    // Guarda los árboles semilleros en la base de datos
//    fun saveSeedTrees() {
//        viewModelScope.launch(Dispatchers.IO) {
//            saveSeedTreesUseCase(_seedTrees.value)
//        }
//    }

    // Guarda los árboles semilleros en la variable de estado
    fun setSeedTrees(seedTrees: List<SeedTree>){
        _seedTrees.value = seedTrees
    }

    fun plantSeedInForest(forestTree: ForestTree, seedTreeId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.i("GroveViewModel", "BEFORE PLANTING plantForestTreeInForest: ${_forestTrees.value.size}")
            var position = forestTree.position
            while (_forestTrees.value.getOrNull(position) != null) { // Check if position is occupied
                position = (0..24).random() // Generate new random position
            }
            forestTree.position = position // Update tree's position

            // Directly update the element at the desired position
            val updatedForest = _forestTrees.value.toMutableList()
            updatedForest[position] = forestTree
            _forestTrees.value = updatedForest

            insertForestTreeUseCase(forestTree) // Save only the planted tree
//            onCooldownTriggered(seedTreeId) // Trigger cooldown after planting
        }
    }

//    // Actualización del estado del árbol
//    fun updateForestTreeGrowthStage(updatedTree: ForestTree) {
//        viewModelScope.launch(Dispatchers.IO) {
//            updateForestTreeGrowthStageByIdUseCase(updatedTree)
//
//            // Update the UI state
//            val updatedForest = _forestTrees.value.map { tree ->
//                if (tree != null && tree.id == updatedTree.id) {
//                    updatedTree
//                } else {
//                    tree
//                }
//            }
//            _forestTrees.value = updatedForest
//        }
//    }
//
//    fun onCooldownTriggered(seedTreeId: Int) {
//        viewModelScope.launch {
//            val seedTree = getSeedTreeByIdUseCase(seedTreeId).firstOrNull()
//            if (seedTree != null) {
//                seedTree.nextForestTreeAvailableTime = System.currentTimeMillis() + seedTree.timeToGenerateForestTree.toMillis()
//                seedTree.amountOfForestTreesGenerated++
//                updateSeedCooldownUseCase(seedTree) // Update database
//            }
//        }
//    }

    /*
    fun collectOxygen() {
        viewModelScope.launch {
            val oxygen = collectOxygenUseCase() // Delegate to use case
            // Update UI or state with the collected oxygen
        }
    }
     */
}
