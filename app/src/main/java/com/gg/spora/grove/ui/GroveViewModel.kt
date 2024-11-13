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
import kotlinx.coroutines.Job
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

    private val _forestTreeGrowthTimes = MutableStateFlow<Map<Int, Long>>(emptyMap())
    val forestTreeGrowthTimes: StateFlow<Map<Int, Long>> = _forestTreeGrowthTimes.asStateFlow()

    private val growthTimerJobs = mutableMapOf<Int, Job>() // Store timer jobs

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

    override fun onCleared() {
        super.onCleared()
        // Cancel all growth timer jobs
        growthTimerJobs.values.forEach { it.cancel() }
    }

    // Inicialización de los casos de uso
    init {
        viewModelScope.launch(Dispatchers.IO) {
            combine(
                loadSeedTreesUseCase(),
                loadForestTreesUseCase(),
                seedTreeCooldowns
            ) { seedTrees, forestTrees, seedTreeCooldowns ->
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

                // Initialize _forestTreeGrowthTimes with existing growth times
                _forestTreeGrowthTimes.update { currentGrowthTimes ->
                    forestTrees.associate { forestTree ->
                        val treeId = forestTree?.id ?: 0
                        treeId to (currentGrowthTimes[treeId] ?: 0L)
                    }
                }

                _forestTrees.value.forEach { forestTree ->
                    forestTree?.let { tree ->
                        if (!tree.hasReachedAdultStage) {
                            startGrowthTimer(tree.id)
                        }
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
                Log.i(
                    "GroveViewModel",
                    "SeedTreeCooldowns initialized: ${_seedTreeCooldowns.value}"
                )
            }
        }
    }

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

            val totalSeconds = Duration.between(forestTree.plantingDate, LocalDateTime.now()).seconds

            // Initialize growth time for the inserted tree
            _forestTreeGrowthTimes.update { timers -> timers + (forestTree.id to totalSeconds) }
            Log.i("GroveViewModel", "Growth time initialized: ${_forestTreeGrowthTimes.value}")

            // Update only the specific tree in the list
            val updatedForestTrees = _forestTrees.value.toMutableList()
            val index = updatedForestTrees.indexOfFirst { it?.id == forestTree.id }
            if (index != -1) {
                updatedForestTrees[index] = forestTree.copy() // Use copy to create a new object
            } else {
                // If the tree is not found (newly planted), add it to the list
                updatedForestTrees.add(forestTree.copy())
            }
            _forestTrees.value = updatedForestTrees // Update _forestTrees with the modified list

            // Trigger cooldown separately (if needed)
            triggerSeedTreeCooldown(seedTreeId)

            // Start growth timer for the newly planted tree
            if(!forestTree.hasReachedAdultStage){
                startGrowthTimer(forestTree.id)
            }
        }
    }

    // Separate function to trigger cooldown
    fun triggerSeedTreeCooldown(seedTreeId: Int) {
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

    private fun startGrowthTimer(treeId: Int) {
        // Cancel any existing timer job for this specific tree
        growthTimerJobs[treeId]?.cancel()

        growthTimerJobs[treeId] = viewModelScope.launch(Dispatchers.IO) {
            var forestTree = _forestTrees.value.find { it?.id == treeId }
            while (forestTree != null && !forestTree.hasReachedAdultStage) {
                delay(1000)
                updateForestTreeGrowthTime(treeId)
                // Re-fetch the forest tree to get updated values
                forestTree = _forestTrees.value.find { it?.id == treeId }
            }
        }
    }

    private fun updateForestTreeGrowthTime(forestTreeId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val forestTree = _forestTrees.value.find { it?.id == forestTreeId }
            forestTree?.let {
                if (!it.hasReachedAdultStage) {
                    // Increment growth time by 1 second
                    _forestTreeGrowthTimes.update { currentGrowthTimes ->
                        val currentGrowthTime = currentGrowthTimes[forestTreeId] ?: 0L
                        currentGrowthTimes + (forestTreeId to (currentGrowthTime + 1))
                    }

                    // Update growth stage
                    updateGrowthStage(it)
                    // Update the ForestTree in the list
                    updateForestTree(it.copy())
                }
            }
        }
    }

    fun updateGrowthStage(forestTree: ForestTree) {
        val totalSeconds = Duration.between(forestTree.plantingDate, LocalDateTime.now()).seconds

        Log.d("GroveViewModel", "Total seconds: $totalSeconds")

        forestTree.currentStage = when {
            totalSeconds < 5 -> GrowthStage.SPROUT
            totalSeconds in 5..10 -> GrowthStage.MEDIUM
            else -> {
                forestTree.hasReachedAdultStage = true
                GrowthStage.ADULT
            }
        }
        Log.d("GroveViewModel", "Current stage: ${forestTree.currentStage}")
    }

    private fun updateForestTree(updatedTree: ForestTree) {
        val updatedForestTrees = _forestTrees.value.toMutableList()
        val index = updatedForestTrees.indexOfFirst { it?.id == updatedTree.id }
        if (index != -1) {
            updatedForestTrees[index] = updatedTree
            _forestTrees.value = updatedForestTrees
        }
    }
}

