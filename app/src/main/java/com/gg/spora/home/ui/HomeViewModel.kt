package com.gg.spora.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.user.domain.GetUserFromNetworkDBUseCase
import com.gg.spora.user.domain.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserFromNetworkDBUseCase: GetUserFromNetworkDBUseCase
) : ViewModel(){

    private val _user = MutableStateFlow<User?>(null)
    val user = _user.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        getUser()
    }

    private fun getUser(){
        viewModelScope.launch {
            _isLoading.value = true
            getUserFromNetworkDBUseCase().collect{
                _user.value = it
            }
            _isLoading.value = false
        }
    }

}