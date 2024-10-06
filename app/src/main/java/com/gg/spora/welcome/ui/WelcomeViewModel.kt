package com.gg.spora.welcome.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor() : ViewModel(){

    val _guestName = MutableStateFlow<String>("")
    val guestName: StateFlow<String> = _guestName


    fun setGuestName(name: String) {
        _guestName.value = name
    }

    fun getGuestName(): String {
        return _guestName.value
    }
}
