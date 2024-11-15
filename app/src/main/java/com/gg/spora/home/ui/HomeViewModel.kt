package com.gg.spora.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.tutorials.data.TutorialModels
import com.gg.spora.tutorials.model.TutorialItem
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

    private val _showTutorial = MutableStateFlow(false)
    val showTutorial = _showTutorial.asStateFlow()

    private val _homeTutorial = MutableStateFlow<List<TutorialItem>>(emptyList())
    val homeTutorial = _homeTutorial.asStateFlow()

    private val _currentTutorialIndex = MutableStateFlow(0)
    val currentTutorialIndex = _currentTutorialIndex.asStateFlow()

    private val _currentTutorialItem = MutableStateFlow<TutorialItem?>(null)
    val currentTutorialItem = _currentTutorialItem.asStateFlow()

    init {
//        getUser()
        getHomeTutorial()
        getOxygen()
    }

    private fun getHomeTutorial(){
        _homeTutorial.value = TutorialModels.homeTutorials

        _currentTutorialItem.value = _homeTutorial.value.first()
    }

    fun nextTutorialItem(){
        val nextIndex = _currentTutorialIndex.value + 1
        if(nextIndex < _homeTutorial.value.size -1){
            _currentTutorialIndex.value = nextIndex
            _currentTutorialItem.value = _homeTutorial.value[nextIndex]
        }else{
            _showTutorial.value = false
        }
    }

    fun skipTutorial(){
        _showTutorial.value = false
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