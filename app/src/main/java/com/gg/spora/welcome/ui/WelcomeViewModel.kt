package com.gg.spora.welcome.ui

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(private val dataStore: DataStore<Preferences>) :
    ViewModel() {

    private val _guestName = MutableStateFlow<String>("")
    val guestName: StateFlow<String> = _guestName


    init {
        getGuestName()
    }

    fun setGuestName(name: String) {
        viewModelScope.launch {
            dataStore.edit { pref ->
                pref[stringPreferencesKey("username")] = name
            }
        }
    }

    fun getGuestName() {

        viewModelScope.launch {
            dataStore.data.map { pref ->
                pref[stringPreferencesKey("username")] ?: ""
            }.collect {
                _guestName.value = it
                Log.i("username", _guestName.value)
            }
        }
    }

}
