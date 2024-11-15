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
import com.gg.spora.grove.domain.models.GroveUiState
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

    private val _seedTreeCooldowns = MutableStateFlow<Map<String, Long>>(emptyMap())
    val seedTreeCooldowns: StateFlow<Map<String, Long>> = _seedTreeCooldowns.asStateFlow()

    private val _isLoading = MutableStateFlow(true) // Loading state
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _forestTreeGrowthTimes = MutableStateFlow<Map<String, Long>>(emptyMap())
    val forestTreeGrowthTimes: StateFlow<Map<String, Long>> = _forestTreeGrowthTimes.asStateFlow()

    // Combined flow for seedTrees and forestTrees
    val uiState: StateFlow<GroveUiState> = combine(
        seedTrees,
        forestTrees,
        seedTreeCooldowns,
        forestTreeGrowthTimes
    ) { seedTrees, forestTrees, seedTreeCooldowns, forestTreeGrowthTimes ->
        GroveUiState(seedTrees, forestTrees, seedTreeCooldowns, forestTreeGrowthTimes)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        GroveUiState(emptyList(), emptyList(), emptyMap(), emptyMap())
    )

    // Inicialización de los casos de uso
    init {
        viewModelScope.launch(Dispatchers.IO) {

            // Separate launch block for seedTreeCooldowns updates
            launch {
                loadSeedTreesUseCase().collect { seedTrees ->
                    _seedTreeCooldowns.update { currentCooldowns ->
                        seedTrees.associate { seedTree ->
                            seedTree.id to (currentCooldowns[seedTree.id] ?: 0L)
                        }
                    }
                }
            }

            // Separate launch block for forestTreeGrowthTimes updates
            launch {
                loadForestTreesUseCase().collect { forestTrees ->
                    _forestTreeGrowthTimes.update { currentGrowthTimes ->
                        forestTrees.associate { forestTree ->
                            val treeId = forestTree?.id?.toString() ?: "0" // Cast to String
                            treeId to (currentGrowthTimes.getOrDefault(
                                treeId,
                                Duration.between(
                                    forestTree?.plantingDate ?: LocalDateTime.now(),
                                    LocalDateTime.now()
                                ).seconds
                            ))
                        }
                    }
                }
            }

            combine(
                loadSeedTreesUseCase(),
                loadForestTreesUseCase(),
            ) { seedTrees, forestTrees ->
                Pair(seedTrees, forestTrees)
            }.collect { (seedTrees, forestTrees) ->
                _seedTrees.update { seedTrees }
                _forestTrees.update { forestTrees }

                initSeedTrees()
                _isLoading.value = false
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
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
                Log.i(
                    "GroveViewModel",
                    "SeedTreeCooldowns initialized: ${_seedTreeCooldowns.value}"
                )
            }
        }
    }

    fun plantForestTree(forestTree: ForestTree, seedTreeId: String) {
        viewModelScope.launch(Dispatchers.IO) {

            // Generate a random position until an empty position is found
            var position = forestTree.position
            while (_forestTrees.value.getOrNull(position) != null) { // Check if position is occupied
                position = (0..24).random() // Generate new random position
            }
            forestTree.position = position // Update tree's position

            // Save the planted tree to the database
            insertForestTreeUseCase(forestTree)
            // Trigger cooldown for SeedTrees
            triggerSeedTreeCooldown(seedTreeId)
            // Start growth timer only for the newly planted tree
            updateForestTreeGrowthTime(forestTree)
        }
    }

    // Separate function to trigger cooldown
    fun triggerSeedTreeCooldown(seedTreeId: String) {
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
                Log.i(
                    "GroveViewModel",
                    "Cooldown remaining for seedTreeId: $remainingTime ${_seedTreeCooldowns.value}"
                )
            }

            // Reset cooldown to 0 when finished
            _seedTreeCooldowns.update { currentCooldowns ->
                currentCooldowns + (seedTreeId to 0L)
            }
            Log.i("GroveViewModel", "Cooldown finished for seedTreeId: ${_seedTreeCooldowns.value}")
        }
    }

    private fun updateForestTreeGrowthTime(forestTree: ForestTree) {
        viewModelScope.launch(Dispatchers.IO) {
            var elapsedTime = Duration.between(forestTree.plantingDate, LocalDateTime.now()).seconds
            while (!forestTree.hasReachedAdultStage) {
                delay(1000) // Delay for 1 second
                elapsedTime++ // Increment elapsed time by 1 second
                // Update growth time in the map
                Log.i("GroveViewModel", "id del arbol ${forestTree.id}")
                _forestTreeGrowthTimes.update { currentGrowthTimes ->
                    currentGrowthTimes + (forestTree.id to elapsedTime)
                }

                Log.d("GroveViewModel", "${_forestTreeGrowthTimes.value}")
                Log.d("GroveViewModel", "$elapsedTime")

                // Update growth stage
                updateGrowthStage(forestTree) // Pass elapsedTime to updateGrowthStage
            }
        }
    }

    suspend fun updateGrowthStage(forestTree: ForestTree) {
        forestTree.currentStage = when {
            _forestTreeGrowthTimes.value.getValue(forestTree.id) < 5 -> GrowthStage.SPROUT
            _forestTreeGrowthTimes.value.getValue(forestTree.id) in 5..10 -> GrowthStage.MEDIUM
            else -> {
                forestTree.hasReachedAdultStage = true
                GrowthStage.ADULT
            }
        }
        updateForestTreeGrowthStageByIdUseCase(forestTree)
    }
}

