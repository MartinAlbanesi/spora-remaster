// ProfileViewModel.kt
package com.gg.spora.profile.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private val _currentIndex = MutableStateFlow(0)
    val currentIndex: StateFlow<Int> = _currentIndex

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

