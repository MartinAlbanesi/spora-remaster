package com.gg.spora.core.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.core.domain.CanAccessToAppUseCase
import com.gg.spora.user.domain.GetUserLocalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserLocalUseCase: GetUserLocalUseCase,
    private val canAccessToAppUseCase: CanAccessToAppUseCase
) : ViewModel() {

    private val _isUserLoggedIn = MutableStateFlow<Boolean?>(null)
    val isUserLoggedIn = _isUserLoggedIn.asStateFlow()

    private val _canAccessToApp = MutableStateFlow<Boolean?>(null)
    val canAccessToApp = _canAccessToApp.asStateFlow()

    init {
        viewModelScope.launch {

            _canAccessToApp.value = canAccessToAppUseCase()

            Log.i("titi", "canAccessToApp: ${_canAccessToApp.value}")

            getUserLocalUseCase().collect {
                _isUserLoggedIn.value = it != null
            }
        }
    }

}