package com.gg.spora.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.Tutorials
import com.gg.spora.home.domain.functions.formatDuration
import com.gg.spora.home.domain.functions.getChampyHomeQuote
import com.gg.spora.home.domain.functions.timeStampToLocalDateTime
import com.gg.spora.missions.domain.SetNewDailyMissionsUseCase
import com.gg.spora.missions.data.local.MissionModels
import com.gg.spora.missions.domain.ClaimMissionUseCase
import com.gg.spora.missions.domain.GetMissionsUseCase
import com.gg.spora.missions.domain.models.Mission
import com.gg.spora.tutorials.domain.TutorialSelected
import com.gg.spora.user.domain.GetUserAuthUseCase
import com.gg.spora.user.domain.GetUserLocalUseCase
import com.gg.spora.user.domain.SyncUserNetworkDataUseCase
import com.gg.spora.user.domain.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalDateTime
import javax.inject.Inject
import kotlin.random.Random
import kotlin.time.toKotlinDuration

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserLocalUseCase: GetUserLocalUseCase,
    private val getUserAuthUseCase: GetUserAuthUseCase,
    val tutorialSelected: TutorialSelected,
    private val getMissionsUseCase: GetMissionsUseCase,
    private val claimMissionUseCase: ClaimMissionUseCase,
    private val setNewDailyMissionsUseCase: SetNewDailyMissionsUseCase,
    private val syncUserNetworkDataUseCase: SyncUserNetworkDataUseCase
) : ViewModel() {

    private val _oxygen = MutableStateFlow(0)
    val oxygen = _oxygen.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val _champyQuote = MutableStateFlow<String?>(null)
    val champyQuote = _champyQuote.asStateFlow()

    private var _user = MutableStateFlow<User?>(null)
    val user = _user.asStateFlow()

    private var hasShowWelcomeMessage = false

    private val _isUserLoggedIn = MutableStateFlow(false)
    val isUserLoggedIn = _isUserLoggedIn.asStateFlow()

    private val _missions = MutableStateFlow(emptyList<Mission>())
    val missions = _missions.asStateFlow()

    private val _missionResetTime = MutableStateFlow("")
    val missionResetTime = _missionResetTime.asStateFlow()

    init {

        getResetTime()
        getUserName()
        tutorialSelected.getTutorial(Tutorials.HOME_TUTORIAL)
        getOxygen()
        getChampyQuote()
        getMissions()
        syncUserNetworkData()
    }

    private fun syncUserNetworkData() {
        viewModelScope.launch {
            syncUserNetworkDataUseCase()
        }
    }

    private fun getMissions() {
        viewModelScope.launch {
            getMissionsUseCase().collect {
                _missions.value = it
            }
        }
    }

    private fun getUserName() {
        viewModelScope.launch {
            _isUserLoggedIn.value = getUserAuthUseCase() != null
            getUserLocalUseCase().collect {
                _user.value = it
            }
        }
    }

    private fun getResetTime() {
        viewModelScope.launch(Dispatchers.Main) {

            var duration: kotlin.time.Duration

            while (true) {

                val userFlow = async { getUserLocalUseCase().first() }.await()

                duration = Duration.between(
                    LocalDateTime.now(),
                    timeStampToLocalDateTime(userFlow!!.resetDailyMission)
                ).toKotlinDuration()

                if (duration.inWholeSeconds <= 0) {

                    async { setNewDailyMissionsUseCase(MissionModels.missions) }.await()

                    _missionResetTime.value = formatDuration(duration)
                }

                while (duration.inWholeSeconds > 0) {

                    duration = Duration.between(
                        LocalDateTime.now(),
                        timeStampToLocalDateTime(userFlow.resetDailyMission)
                    ).toKotlinDuration()

                    _missionResetTime.value = formatDuration(duration)

                    delay(1000)
                }
            }
        }
    }

    fun getTutorial(tutorials: Tutorials, secondaryAction: () -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            tutorialSelected.getTutorial(tutorials, secondaryAction)
        }
    }


    private fun getOxygen() {
        viewModelScope.launch(Dispatchers.Main) {
            getUserLocalUseCase().collect {
                _oxygen.value = it?.oxygen ?: 0
            }
        }
    }

    private fun getChampyQuote() {
        viewModelScope.launch(Dispatchers.Main) {
            while (true) {
                delay(Random.nextLong(3000, 5000))
                _champyQuote.value = if (!hasShowWelcomeMessage) {
                    hasShowWelcomeMessage = true
                    getChampyHomeQuote(_user.value?.userName ?: "")
                } else {
                    SporaConstant.CHAMPY_RANDOM_QUOTE.random()
                }

                delay(7000)
                _champyQuote.value = null
            }
        }
    }

    fun claimMission(missionId: Byte, oxygenReward: Byte) {
        viewModelScope.launch {
            claimMissionUseCase(missionId, oxygenReward.toInt())
        }
    }

}