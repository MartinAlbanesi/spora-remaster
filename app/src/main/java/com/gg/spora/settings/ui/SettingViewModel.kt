package com.gg.spora.settings.ui

import androidx.lifecycle.ViewModel
import com.gg.spora.login.domain.LogOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val logOutUseCase: LogOutUseCase
): ViewModel() {

    fun logout(
        onNavigateToLogin: () -> Unit
    ) {
        logOutUseCase()
        onNavigateToLogin()
    }
}