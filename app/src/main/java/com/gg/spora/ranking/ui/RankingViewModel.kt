package com.gg.spora.ranking.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.user.domain.GetAllUserNetworkUseCase
import com.gg.spora.user.domain.GetUserLocalUseCase
import com.gg.spora.user.domain.models.User
import com.google.type.DayOfWeek
import com.google.type.DayOfWeek.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAdjusters
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class RankingViewModel @Inject constructor(
    private val getAllUserNetworkUseCase: GetAllUserNetworkUseCase,
    private val getUserLocalUseCase: GetUserLocalUseCase
): ViewModel() {

    private val _rankingItems = MutableStateFlow<List<User>>(emptyList())
    val rankingItems: StateFlow<List<User>> = _rankingItems

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser

    private val _timeUntilReset = MutableStateFlow<Duration>(Duration.ZERO)
    val timeUntilReset: StateFlow<Duration> = _timeUntilReset

    init {
        loadRankingData()
        getUserLocal()
        startCountdownTimer()
        updateTimeUntilReset()
    }

    private fun updateTimeUntilReset() {
        viewModelScope.launch {
            while (true) {
                _timeUntilReset.value = calculateTimeUntilNextMonday()
                delay(1000L)
            }
        }
    }

    fun calculateTimeUntilNextMonday(): Duration {
        val now = LocalDateTime.now()
        val nextMonday = now.with(TemporalAdjusters.next(java.time.DayOfWeek.MONDAY)).withHour(0).withMinute(0).withSecond(0).withNano(0)
        return Duration.between(now, nextMonday)
    }

    private fun loadRankingData() {
        viewModelScope.launch {
            getAllUserNetworkUseCase().collect {
                _rankingItems.value = it.sortedByDescending { user -> user.weeklyOxygen }
            }
        }
    }

    private fun getUserLocal() {
        viewModelScope.launch {
            getUserLocalUseCase().collect {
                _currentUser.value = it
            }
        }
    }


    private fun resetWeeklyOxygen() {
        viewModelScope.launch {
            _rankingItems.value = _rankingItems.value.map { it.copy(weeklyOxygen = 0) }
            _currentUser.value = _currentUser.value?.copy(weeklyOxygen = 0)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun startCountdownTimer() {
        viewModelScope.launch {
            while (true) {
                val now = LocalDateTime.now()
                val nextReset = now.with(ChronoUnit.DAYS.addTo(now, 7 - now.dayOfWeek.value.toLong()))
                _timeUntilReset.value = Duration.between(now, nextReset)
                if (_timeUntilReset.value.isZero) {
                    resetWeeklyOxygen()
                }
                delay(1000L)
            }
        }
    }
}
