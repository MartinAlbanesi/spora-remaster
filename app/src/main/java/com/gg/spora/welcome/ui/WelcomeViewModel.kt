package com.gg.spora.welcome.ui

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.user.domain.SetNewUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
//    private val dataStore: DataStore<Preferences>
    private val setNewUserUseCase: SetNewUserUseCase
) : ViewModel() {

    private val _guestName = MutableStateFlow("")

    fun setGuestName(name: String) {
        viewModelScope.launch {
            _guestName.value = name
        }
    }

    fun setNewUser() {
        viewModelScope.launch {
            setNewUserUseCase(null, _guestName.value)
        }
    }

//    fun getGuestName() {
//
//        viewModelScope.launch {
//            dataStore.data.map { pref ->
//                pref[stringPreferencesKey("username")] ?: ""
//            }.collect {
//                _guestName.value = it
//                Log.i("username", _guestName.value)
//            }
//        }
//    }

}
