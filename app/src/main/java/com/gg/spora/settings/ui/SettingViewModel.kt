package com.gg.spora.settings.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.login.domain.LogOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val logOutUseCase: LogOutUseCase
) : ViewModel() {

    fun logout(
        onNavigateToLogin: () -> Unit
    ) {
        viewModelScope.launch(Dispatchers.Main) {
            logOutUseCase()
            onNavigateToLogin()
        }
    }
}