package com.gg.spora.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.user.domain.GetUserNetworkUseCase
import com.gg.spora.user.domain.GetUserOxygenUseCase
import com.gg.spora.user.domain.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
//    private val getUserNetworkUseCase: GetUserNetworkUseCase
    private val getUserOxygenUseCase: GetUserOxygenUseCase
) : ViewModel(){

    private val _user = MutableStateFlow<User?>(null)
    val user = _user.asStateFlow()

    private val _oxygen = MutableStateFlow(0)
    val oxygen = _oxygen.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
//        getUser()
        getOxygen()
    }

    private fun getOxygen(){
        viewModelScope.launch {
            getUserOxygenUseCase().collect{
                _oxygen.value = it
            }
        }
    }

//    private fun getUser(){
//        viewModelScope.launch {
//            _isLoading.value = true
//            getUserNetworkUseCase().collect{
//                _user.value = it
//            }
//            _isLoading.value = false
//        }
//    }

}