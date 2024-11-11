package com.gg.spora.grove.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.grove.domain.GetSeedTreeByIdUseCase
import com.gg.spora.grove.domain.InsertForestTreeUseCase
import com.gg.spora.grove.domain.LoadForestTreesUseCase
import com.gg.spora.grove.domain.LoadSeedTreesUseCase
import com.gg.spora.grove.domain.SaveSeedTreesUseCase
import com.gg.spora.grove.domain.UpdateForestTreeGrowthStageByIdUseCase
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.GrowthStage
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalDateTime
import javax.inject.Inject
import kotlin.collections.associate

const val INITIAL_COOLDOWN_DURATION = 5000L

// Evitar que se dibuje la pantalla con un evento, escuchar el evento desde la UI
// Programacion reactiva
/**
 * ViewModel para la pantalla del grove.
 * @param getSeedTreesUseCase Caso de uso para obtener los árboles semilleros.
 * @param getForestTreesUseCase Caso de uso para obtener los árboles del bosque.
 * @param plantSeedUseCase Caso de uso para plantar una semilla.
 * @param collectOxygenUseCase Caso de uso para recolectar oxígeno.
 */
@HiltViewModel
class GroveViewModel @Inject constructor(
    private val loadSeedTreesUseCase: LoadSeedTreesUseCase,
    private val saveSeedTreesUseCase: SaveSeedTreesUseCase,
    private val loadForestTreesUseCase: LoadForestTreesUseCase,
    private val insertForestTreeUseCase: InsertForestTreeUseCase,
    private val getSeedTreeByIdUseCase: GetSeedTreeByIdUseCase,
    private val updateForestTreeGrowthStageByIdUseCase: UpdateForestTreeGrowthStageByIdUseCase,
) : ViewModel() {

    // State variables for
    private val _seedTrees = MutableStateFlow<List<SeedTree>>(emptyList())
    val seedTrees: StateFlow<List<SeedTree>> = _seedTrees.asStateFlow()

    private val _forestTrees = MutableStateFlow<List<ForestTree?>>(emptyList())
    val forestTrees: StateFlow<List<ForestTree?>> = _forestTrees.asStateFlow()

    private val _seedTreeCooldowns = MutableStateFlow<Map<Int, Long>>(emptyMap())
    val seedTreeCooldowns: StateFlow<Map<Int, Long>> = _seedTreeCooldowns.asStateFlow()

    private val _isLoading = MutableStateFlow(true) // Loading state
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    // Combined flow for seedTrees and forestTrees
    val uiState: StateFlow<Triple<List<SeedTree>, List<ForestTree?>, Map<Int, Long>>> =
        combine(
            seedTrees,
            forestTrees,
            seedTreeCooldowns
        ) { seedTrees, forestTrees, seedTreeCooldowns ->
            Triple(seedTrees, forestTrees, seedTreeCooldowns)
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            Triple(emptyList(), emptyList(), emptyMap())
        )

    // Inicialización de los casos de uso
    init {
        viewModelScope.launch(Dispatchers.IO) {
            combine(loadSeedTreesUseCase(), loadForestTreesUseCase(), seedTreeCooldowns) { seedTrees, forestTrees, seedTreeCooldowns ->
                Triple(seedTrees, forestTrees, seedTreeCooldowns)
            }.collect { (seedTrees, forestTrees, _) ->
                _seedTrees.update { seedTrees }
                _forestTrees.update { forestTrees }

                // Initialize _seedTreeCooldowns with INITIAL_COOLDOWN_DURATION
                _seedTreeCooldowns.update { currentCooldowns ->
                    seedTrees.associate { seedTree ->
                        seedTree.id to (currentCooldowns[seedTree.id] ?: 0L)
                    }
                }

                initSeedTrees()
                _isLoading.value = false
            }
        }
    }

    // Inicializa los árboles semilleros la primera vez que se abre la pantalla
    fun initSeedTrees() {
        viewModelScope.launch(Dispatchers.IO) {
            if (_seedTrees.value.isEmpty()) {
                val initialSeedTrees = listOf(
                    SeedTree(type = TreeType.PINE),
                    SeedTree(type = TreeType.SECUOYA),
                    SeedTree(type = TreeType.MANGROVE)
                )

                saveSeedTreesUseCase(initialSeedTrees)
                Log.i("GroveViewModel", "SeedTreeCooldowns initialized: ${_seedTreeCooldowns.value}")
            }
        }
    }

//    // Carga los árboles semilleros desde la base de datos
//    fun getSeedTrees(): Flow<List<SeedTree>> {
//        viewModelScope.launch(Dispatchers.IO) {
//            var seedTrees: List<SeedTree>
//            loadSeedTreesUseCase().collect {
//                seedTrees = it
//            }
//        }
//        return seedTrees
//    }
//
//    // Carga los árboles del bosque desde la base de datos para Test
//    fun getForestTrees(): Flow<List<ForestTree?>> {
//        viewModelScope.launch(Dispatchers.IO) {
//            var forestTrees: List<ForestTree?>
//            loadForestTreesUseCase().collect {
//                forestTrees = it
//            }
//        }
//        return forestTrees
//    }

    fun plantForestTree(forestTree: ForestTree, seedTreeId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            var position = forestTree.position
            while (_forestTrees.value.getOrNull(position) != null) { // Check if position is occupied
                position = (0..24).random() // Generate new random position
            }
            forestTree.position = position // Update tree's position

            // Directly update the element at the desired position
            val updatedForest = _forestTrees.value.toMutableList()
            updatedForest[position] = forestTree
            _forestTrees.update { updatedForest }

            insertForestTreeUseCase(forestTree) // Save only the planted tree
        }
    }

    // Guardar la fecha en la que se genero un arbol para luego compararla y asignarla a la variable del viewmodel
    fun onSeedTreeButtonClicked(seedTreeId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            // Reset cooldown to initial value
            _seedTreeCooldowns.update { currentCooldowns ->
                currentCooldowns + (seedTreeId to INITIAL_COOLDOWN_DURATION)
            }

            Log.i("GroveViewModel", "Cooldown reset for seedTreeId: ${_seedTreeCooldowns.value}")

            // Decrement cooldown until it reaches 0
            var remainingTime = INITIAL_COOLDOWN_DURATION
            while (remainingTime > 0) {
                delay(1000)
                remainingTime -= 1000
                _seedTreeCooldowns.update { currentCooldowns ->
                    currentCooldowns + (seedTreeId to remainingTime)
                }
                Log.i("GroveViewModel", "Cooldown remaining for seedTreeId: $remainingTime ${_seedTreeCooldowns.value}")
            }

            // Reset cooldown to 0 when finished
            _seedTreeCooldowns.update { currentCooldowns ->
                currentCooldowns + (seedTreeId to 0L)
            }
            Log.i("GroveViewModel", "Cooldown finished for seedTreeId: ${_seedTreeCooldowns.value}")
        }
    }

//    private fun updateForestTreeGrowthStages() {
//        viewModelScope.launch(Dispatchers.IO) {
//            while (true) {
//                val updatedForestTrees = _forestTrees.value.map { forestTree ->
//                    forestTree?.let {
//                        if (!it.hasReachedAdultStage) {
//                            val updatedTree = it.copy().apply { updateGrowthStage(this) }
//                            updatedTree // Retorna el árbol actualizado
//                        } else {
//                            it // Retorna el árbol sin actualizar si ya alcanzó la etapa adulta
//                        }
//                    }
//                }
//                _forestTrees.value = updatedForestTrees
//                delay(1000) // Update every 1 second
//            }
//        }
//    }

    fun updateGrowthStage(forestTree: ForestTree) {
        var secondsGoneBy =
            Duration.between(forestTree.plantingDate, LocalDateTime.now()).toSeconds().toInt()

        Log.d("ForestTree", "Seconds gone by: $secondsGoneBy")

        forestTree.currentStage = when {
            secondsGoneBy < 5 -> GrowthStage.SPROUT // 5 seconds
            secondsGoneBy in 5..10 -> GrowthStage.MEDIUM // 5-10 seconds
            else -> {
                forestTree.hasReachedAdultStage =
                    true // Setea el flag en true cuando el árbol llegue a la etapa adulta
                GrowthStage.ADULT // 10 segundos o más
            }
        }
        Log.d("ForestTree", "Current stage: ${forestTree.currentStage}")
    }

    fun updateForestTree(updatedTree: ForestTree) {
        val updatedForestTrees = _forestTrees.value.toMutableList()
        val index = updatedForestTrees.indexOfFirst { it?.id == updatedTree.id }
        if (index != -1) {
            updatedForestTrees[index] = updatedTree
            _forestTrees.update { updatedForestTrees } // Actualiza la variable StateFlow
        }
    }
}

