package com.gg.spora.ranking.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.user.domain.GetAllUserNetworkUseCase
import com.gg.spora.user.domain.GetUserLocalUseCase
import com.gg.spora.user.domain.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import javax.inject.Inject

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

    private fun startCountdownTimer() {
        viewModelScope.launch {
            while (true) {
                val now = LocalDateTime.now()
                val nextReset = now.with(ChronoUnit.DAYS.addTo(now, 7 - now.dayOfWeek.value.toLong()))
                _timeUntilReset.value = Duration.between(now, nextReset)
                kotlinx.coroutines.delay(1000L)
            }
        }
    }
}
