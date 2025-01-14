package com.gg.spora.grove.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.BuildConfig.GROWTH_TIME_DURATION
import com.gg.spora.BuildConfig.INITIAL_COOLDOWN_DURATION
import com.gg.spora.BuildConfig.MAX_TIMES_TO_CLAIM_OXYGEN
import com.gg.spora.BuildConfig.OXYGEN_COOLDOWN_DURATION
import com.gg.spora.core.utils.enums.Tutorials
import com.gg.spora.grove.domain.DeleteForestTreeByIdUseCase
import com.gg.spora.grove.domain.GetCooldownDataByIdUseCase
import com.gg.spora.grove.domain.InsertCooldownDataUseCase
import com.gg.spora.grove.domain.InsertForestTreeUseCase
import com.gg.spora.grove.domain.LoadForestTreesUseCase
import com.gg.spora.grove.domain.LoadSeedTreesUseCase
import com.gg.spora.grove.domain.SaveSeedTreesUseCase
import com.gg.spora.grove.domain.UpdateForestTreeGrowthStageByIdUseCase
import com.gg.spora.grove.domain.UpdateTimesOxygenClaimedUseCase
import com.gg.spora.grove.domain.models.CooldownData
import com.gg.spora.grove.domain.models.ForestTree
import com.gg.spora.grove.domain.models.GroveUiState
import com.gg.spora.grove.domain.models.GrowthStage
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
import com.gg.spora.grove.utils.functions.combine
import com.gg.spora.missions.domain.enums.MissionType
import com.gg.spora.missions.domain.models.MissionManager
import com.gg.spora.tutorials.domain.TutorialSelected
import com.gg.spora.user.domain.GetUserOxygenUseCase
import com.gg.spora.user.domain.UpdateUserOxygenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import java.time.Duration
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import javax.inject.Inject

//const val INITIAL_COOLDOWN_DURATION = /*43200000L*/ 10000L
//const val OXYGEN_COOLDOWN_DURATION = /*86400000L*/ 10000L
//const val GROWTH_TIME_DURATION = /*3600000L*/ 10000L
//const val MAX_TIMES_TO_CLAIM_OXYGEN = 3

/**
 * View model for the Grove screen.
 * @param loadSeedTreesUseCase Use case to load seed trees.
 * @param saveSeedTreesUseCase Use case to save seed trees.
 * @param loadForestTreesUseCase Use case to load forest trees.
 * @param insertForestTreeUseCase Use case to insert a forest tree.
 * @param updateForestTreeGrowthStageByIdUseCase Use case to update a forest tree's growth stage.
 * @param getCooldownDataByIdUseCase Use case to get cooldown data by ID.
 * @param insertCooldownDataUseCase Use case to insert cooldown data.
 * @param updateUserOxygenUseCase Use case to update user oxygen.
 * @param getUserOxygenUseCase Use case to get user oxygen.
 * @param deleteSeedTreeByIdUseCase Use case to delete a seed tree by ID.
 * @param deleteForestTreeByIdUseCase Use case to delete a forest tree by ID.
 */
@HiltViewModel
class GroveViewModel @Inject constructor(
    private val loadSeedTreesUseCase: LoadSeedTreesUseCase,
    private val saveSeedTreesUseCase: SaveSeedTreesUseCase,
    private val loadForestTreesUseCase: LoadForestTreesUseCase,
    private val insertForestTreeUseCase: InsertForestTreeUseCase,
    private val updateForestTreeGrowthStageByIdUseCase: UpdateForestTreeGrowthStageByIdUseCase,
    private val getCooldownDataByIdUseCase: GetCooldownDataByIdUseCase,
    private val insertCooldownDataUseCase: InsertCooldownDataUseCase,
    private val updateUserOxygenUseCase: UpdateUserOxygenUseCase,
    private val getUserOxygenUseCase: GetUserOxygenUseCase,
//    private val deleteSeedTreeByIdUseCase: DeleteSeedTreeByIdUseCase,
    private val deleteForestTreeByIdUseCase: DeleteForestTreeByIdUseCase,
    private val updateTimesOxygenClaimed: UpdateTimesOxygenClaimedUseCase,
    val tutorialSelected: TutorialSelected,
    val missionManager: MissionManager
) : ViewModel() {

    private val _seedTrees = MutableStateFlow<List<SeedTree>>(emptyList())
    val seedTrees: StateFlow<List<SeedTree>> = _seedTrees.asStateFlow()

    private val _forestTrees = MutableStateFlow<List<ForestTree?>>(emptyList())
    val forestTrees: StateFlow<List<ForestTree?>> = _forestTrees.asStateFlow()

    private val _seedTreeCooldowns = MutableStateFlow<Map<String, Long>>(emptyMap())
    val seedTreeCooldowns: StateFlow<Map<String, Long>> = _seedTreeCooldowns.asStateFlow()

    private val _forestTreeGrowthTimes = MutableStateFlow<Map<String, Long>>(emptyMap())
    val forestTreeGrowthTimes: StateFlow<Map<String, Long>> = _forestTreeGrowthTimes.asStateFlow()

    private val _accumulatedOxygen = MutableStateFlow(0)
    val accumulatedOxygen: StateFlow<Int> = _accumulatedOxygen.asStateFlow()

    private val _userOxygen = MutableStateFlow(0)
    val userOxygen: StateFlow<Int> = _userOxygen.asStateFlow()

    private val _oxygenCooldown = MutableStateFlow(0L)
    val oxygenCooldown: StateFlow<Long> = _oxygenCooldown.asStateFlow()

    private val _isLoading = MutableStateFlow(true) // Loading state
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorState = MutableStateFlow<String?>(null)
    val errorState: StateFlow<String?> = _errorState.asStateFlow()

    // Flag to track if initial forest trees have been loaded
    private var _initialForestTreesLoaded = false

//    private val _missions = MutableStateFlow(emptyList<Mission>())
//    val missions = _missions.asStateFlow()

    // Data flow for the UI state, combining all data sources
    val uiState: StateFlow<GroveUiState> = combine(
        seedTrees,
        forestTrees,
        seedTreeCooldowns,
        forestTreeGrowthTimes,
        accumulatedOxygen,
        userOxygen,
        oxygenCooldown
    ) { seedTrees, forestTrees, seedTreeCooldowns, forestTreeGrowthTimes, accumulatedOxygen, userOxygen, oxygenCooldown ->
        GroveUiState(
            seedTrees,
            forestTrees,
            seedTreeCooldowns,
            forestTreeGrowthTimes,
            accumulatedOxygen,
            userOxygen,
            oxygenCooldown,
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        GroveUiState(emptyList(), emptyList(), emptyMap(), emptyMap(), 0, 0, 0L) // Initial value
    )

    init {

        tutorialSelected.getTutorial(Tutorials.GROVE_TUTORIAL)

        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Associated seedTreeId with its cooldown
                launch {

                    loadSeedTreesUseCase().collect { seedTrees ->
                        _seedTreeCooldowns.update { currentCooldowns ->
                            seedTrees.associate { seedTree ->
                                var seedTreeCooldown = 0L

                                if (getCooldownDataByIdUseCase(seedTree.id).first().lastUpdateDate != null) {
                                    seedTreeCooldown = Duration.between(
                                        getCooldownDataByIdUseCase(seedTree.id).first().lastUpdateDate,
                                        LocalDateTime.now()
                                    ).seconds * 1000L
                                }

                                if (currentCooldowns[seedTree.id] != null) {
                                    seedTreeCooldown = currentCooldowns[seedTree.id]!!
                                }
                                else if (seedTreeCooldown > 0L && !isNegative(
                                        INITIAL_COOLDOWN_DURATION - seedTreeCooldown
                                    )
                                ) {
                                    seedTreeCooldown = INITIAL_COOLDOWN_DURATION - seedTreeCooldown
                                    triggerSeedTreeCooldown(seedTree.id, seedTreeCooldown)
                                } else {
                                    seedTreeCooldown = 0L
                                }

                                seedTree.id to (seedTreeCooldown)
                            }
                        }
                    }
                }

                // Associated forestTreeId with its growth time
                launch {
                    loadForestTreesUseCase().collect { forestTrees ->
                        _forestTreeGrowthTimes.update { currentGrowthTimes ->
                            forestTrees.associate { forestTree ->
                                val treeId = forestTree?.id?.toString() ?: "0"

                                // Move updateForestTreeGrowthTime() outside the collect
                                // and trigger it only for the initial list of trees
                                if (!_initialForestTreesLoaded) {
                                    if (forestTree != null) {
                                        updateForestTreeGrowthTime(forestTree)
                                    }
                                }

                                treeId to (currentGrowthTimes.getOrDefault(
                                    treeId,
                                    Duration.between(
                                        forestTree?.plantingDate ?: LocalDateTime.now(),
                                        LocalDateTime.now()
                                    ).seconds
                                ))
                            }
                        }

                        // Set initialForestTreesLoaded to true after the first emission
                        _initialForestTreesLoaded = true
                    }
                }

                // Combine all data sources into the UI state
                kotlinx.coroutines.flow.combine(
                    loadSeedTreesUseCase(),
                    loadForestTreesUseCase(),
                    getUserOxygenUseCase(),
                ) { seedTrees, forestTrees, userOxygen ->
                    Triple(seedTrees, forestTrees, userOxygen)
                }.collect { (seedTrees, forestTrees, userOxygen) ->
                    // Update UI state with the collected data
                    _seedTrees.update { seedTrees }
                    _forestTrees.update { forestTrees }
                    _userOxygen.update { userOxygen }

                    // Initialize seed trees if they are empty
                    initSeedTrees()

                    // Calculate accumulated oxygen
                    calculateAccumulatedOxygen()

                    Log.i("GroveViewModel", "Se repite el combine en init")

                    // Set loading state to false
                    _isLoading.update { false }
                }
            } catch (e: UnknownHostException) {
                _errorState.update { "No internet connection. Please check your connection and try again." }
            } catch (e: Exception) {
                _errorState.update { "An unexpected error occurred. Please try again later." }
            }
        }
    }

    private fun initSeedTrees() {
        viewModelScope.launch(Dispatchers.IO) {
            if (_seedTrees.value.isEmpty()) {
                val initialSeedTrees = listOf(
                    SeedTree(type = TreeType.SECUOYA),
                    SeedTree(type = TreeType.MANGROVE),
                    SeedTree(type = TreeType.BAOBAB),
                )
                saveSeedTreesUseCase(initialSeedTrees)
            }
        }
    }
    private fun isNegative(number: Long): Boolean {
        return number < 0L
    }

    private fun handleException(message: String) {
        _errorState.update { message }
    }

    /*
    // Initialize seed trees if they are empty
    private fun initSeedTrees() {
        viewModelScope.launch(Dispatchers.IO) {
            if (_seedTrees.value.isEmpty()) {
                val initialSeedTrees = listOf(
                    SeedTree(type = TreeType.SECUOYA),
                    SeedTree(type = TreeType.MANGROVE),
                    SeedTree(type = TreeType.BAOBAB),
                )
                saveSeedTreesUseCase(initialSeedTrees)
            }
        }
    }
*/
    // Plants a new forest tree in a random position when seed tree button is clicked
    fun plantForestTree(forestTree: ForestTree, seedTreeId: String) {
        viewModelScope.launch(Dispatchers.IO) {

            try {
                // Generate a random position until an empty position is found
                var position = forestTree.position
                while (_forestTrees.value.getOrNull(position) != null) { // Check if position is occupied
                    position =
                        (0..(_forestTrees.value.size) - 1).random() // Generate new random position
                }
                forestTree.position = position // Update tree's position

                // Save the planted tree to the database
                insertForestTreeUseCase(forestTree)
                // Trigger cooldown for SeedTrees
                triggerSeedTreeCooldown(seedTreeId)
                // Start growth timer only for the newly planted tree
                updateForestTreeGrowthTime(forestTree)
                // Calculate accumulated oxygen for when the tree is adult
                calculateAccumulatedOxygen()

                missionManager.updateMission(MissionType.GROVE_MISSION)
            } catch (e: UnknownHostException) {
                handleException("No internet connection. Please check your connection and try again.")
            } catch (e: Exception) {
                handleException("An unexpected error occurred. Please try again later.")
            }
        }
    }

    // Trigger seed tree cooldown when seed tree button is clicked
    fun triggerSeedTreeCooldown(seedTreeId: String, coolDown: Long = 0L) {
        viewModelScope.launch(Dispatchers.IO) {
            var remainingTime: Long
            // Reset cooldown to initial value
            if (coolDown != 0L) {
                // Decrement cooldown until it reaches 0
                remainingTime = coolDown
            } else {
                insertCooldownDataUseCase(
                    CooldownData(
                        seedTreeId, LocalDateTime.now().truncatedTo(
                            ChronoUnit.SECONDS
                        )
                    )
                )
                _seedTreeCooldowns.update { currentCooldowns ->
                    currentCooldowns + (seedTreeId to INITIAL_COOLDOWN_DURATION)
                }
                // Decrement cooldown until it reaches 0
                remainingTime = INITIAL_COOLDOWN_DURATION
            }
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
        }
    }

    // Updates the growth stage timer for a forest tree
    private fun updateForestTreeGrowthTime(forestTree: ForestTree) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                var elapsedTime = (Duration.between(
                    forestTree.plantingDate,
                    LocalDateTime.now()
                ).seconds) * 1000 // Time in milliseconds

                Log.d("GroveViewModel", "elapsed time: $elapsedTime")

                while (!forestTree.hasReachedAdultStage) {
                    delay(1000) // Delay for 1 second
                    elapsedTime += 1000 // Increment elapsed time by 1 second
                    // Update growth time in the map
                    _forestTreeGrowthTimes.update { currentGrowthTimes ->
                        currentGrowthTimes + (forestTree.id to elapsedTime)
                    }

                    Log.d("GroveViewModel", "Growth Times: ${_forestTreeGrowthTimes.value}")
                    Log.d("GroveViewModel", "Growth Time passed: $elapsedTime")

                    // Update growth stage
                    updateGrowthStage(forestTree) // Pass elapsedTime to updateGrowthStage

                }
            } catch (e: UnknownHostException) {
                handleException("No internet connection. Please check your connection and try again.")
            } catch (e: Exception) {
                handleException("An unexpected error occurred. Please try again later.")
            }
        }
    }

    // Updates the growth stage of a forest tree
    suspend fun updateGrowthStage(forestTree: ForestTree) {
        try {
            // Assigns the growth stage based on elapsed time
            forestTree.currentStage = when {
                _forestTreeGrowthTimes.value.getValue(forestTree.id) < (GROWTH_TIME_DURATION) / 2 -> GrowthStage.SPROUT
                _forestTreeGrowthTimes.value.getValue(forestTree.id) in (GROWTH_TIME_DURATION) / 2..GROWTH_TIME_DURATION -> GrowthStage.MEDIUM
                else -> {
                    forestTree.hasReachedAdultStage = true
                    GrowthStage.ADULT
                }
            }

            // Updates the new growth stage into database
            updateForestTreeGrowthStageByIdUseCase(forestTree)
        } catch (e: UnknownHostException) {
            handleException("No internet connection. Please check your connection and try again.")
        } catch (e: Exception) {
            handleException("An unexpected error occurred. Please try again later.")
        }
    }

    // Calculates the oxygen accumulated by all adult trees planted
    private fun calculateAccumulatedOxygen() {
        var totalOxygen: Int = 0
        _forestTrees.value.forEach { forestTree ->
            if (forestTree?.currentStage == GrowthStage.ADULT) {
                totalOxygen += forestTree.type.oxygenAmount

//                Log.i("GroveViewModel", "Oxygen amount: ${forestTree.type.oxygenAmount}")

            } else {
                0
            }
        }
        _accumulatedOxygen.update { totalOxygen } // Updates the accumulated oxygen value
    }

    // Logic for when the user press the claim daily oxygen button
    fun claimOxygen() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Updates the user's oxygen by the accumulated oxygen
                updateUserOxygenUseCase(accumulatedOxygen.value)

                // Checks the amount of times a tree has given oxygen, if it exceeds the limit, it gets deleted
                checkTreesLifetime()

                // Triggers the cooldown for the button
                triggerOxygenCooldown()
            } catch (e: UnknownHostException) {
                handleException("No internet connection. Please check your connection and try again.")
            } catch (e: Exception) {
                handleException("An unexpected error occurred. Please try again later.")
            }
        }
    }

    // Triggers the claim oxygen cooldown when the button is clicked
    private suspend fun triggerOxygenCooldown() {
        viewModelScope.launch(Dispatchers.IO) {
            _oxygenCooldown.value = OXYGEN_COOLDOWN_DURATION // Set initial cooldown time
            delay(OXYGEN_COOLDOWN_DURATION) // Wait for the cooldown duration
            _oxygenCooldown.value = 0L // Reset cooldown time
        }

        _oxygenCooldown.update { OXYGEN_COOLDOWN_DURATION } // Updates the oxygen cooldown value

        // Decrement cooldown until it reaches 0
        var remainingTime = OXYGEN_COOLDOWN_DURATION
        while (remainingTime > 0) {
            delay(1000)
            remainingTime -= 1000
            _oxygenCooldown.update { remainingTime }
        }

        // Reset cooldown to 0 when finished
        _oxygenCooldown.update { 0L }
    }

    private fun checkTreesLifetime() {
        viewModelScope.launch(Dispatchers.IO) {
            _forestTrees.value.filterNotNull().forEach { forestTree ->
                if(forestTree.currentStage == GrowthStage.ADULT){
                    forestTree.timesOxygenClaimed++
                    updateTimesOxygenClaimed(forestTree)
                }

                forestTree.timesOxygenClaimed.let {
                    if (it >= MAX_TIMES_TO_CLAIM_OXYGEN) {
                        Log.i("GroveViewModel", "Oxygen claimed: ${forestTree.timesOxygenClaimed}")
                        deleteForestTreeByIdUseCase(forestTree.id)
                    }
                }
            }
        }
    }
}

