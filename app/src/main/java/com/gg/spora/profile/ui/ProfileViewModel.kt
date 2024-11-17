// ProfileViewModel.kt
package com.gg.spora.profile.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.R
import com.gg.spora.user.domain.GetUserLocalUseCase
import com.gg.spora.user.domain.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUserLocalUseCase: GetUserLocalUseCase
): ViewModel() {
    private val _currentIndex = MutableStateFlow(0)
    val currentIndex: StateFlow<Int> = _currentIndex

    private val _user = MutableStateFlow<User?>(null)
    val user = _user.asStateFlow()

    init {
        getUserLocal()
    }

    private fun getUserLocal() {
        viewModelScope.launch {
            getUserLocalUseCase().collect {
                _user.value = it
            }
        }
    }

    private val images = listOf(
        R.drawable.logro_semilla,
        R.drawable.plastic_bottle,
        R.drawable.spora_logo_without_slogan
    )

    fun onLeftArrowClick() {
        viewModelScope.launch {
            _currentIndex.value = (_currentIndex.value - 1 + images.size) % images.size
        }
    }

    fun onRightArrowClick() {
        viewModelScope.launch {
            _currentIndex.value = (_currentIndex.value + 1) % images.size
        }
    }

    fun getCurrentImage(): Int {
        return images[_currentIndex.value]
    }
}

