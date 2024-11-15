package com.gg.spora.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.home.domain.functions.getChampyHomeQuote
import com.gg.spora.tutorials.data.TutorialModels
import com.gg.spora.tutorials.model.TutorialItem
import com.gg.spora.user.domain.GetUserLocalUseCase
import com.gg.spora.user.domain.GetUserNetworkUseCase
import com.gg.spora.user.domain.GetUserOxygenUseCase
import com.gg.spora.user.domain.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel @Inject constructor(
//    private val getUserNetworkUseCase: GetUserNetworkUseCase
    private val getUserOxygenUseCase: GetUserOxygenUseCase,
    private val getUserLocalUseCase: GetUserLocalUseCase
) : ViewModel(){

    private val _oxygen = MutableStateFlow(0)
    val oxygen = _oxygen.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val _showTutorial = MutableStateFlow(false)
    val showTutorial = _showTutorial.asStateFlow()

    private val _homeTutorial = MutableStateFlow<List<TutorialItem>>(emptyList())

    private val _currentTutorialIndex = MutableStateFlow(0)

    private val _currentTutorialItem = MutableStateFlow<TutorialItem?>(null)
    val currentTutorialItem = _currentTutorialItem.asStateFlow()

    private val _champyQuote = MutableStateFlow<String?>(null)
    val champyQuote = _champyQuote.asStateFlow()

    private val _userName = MutableStateFlow("")

    init {
//        getUser()
        getUserName()
        getHomeTutorial()
        getOxygen()
    }

    private fun getUserName(){
        viewModelScope.launch {
            getUserLocalUseCase().collect{
                _userName.value = it?.userName ?: ""
            }
        }
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
            getUserLocalUseCase().collect{
                _oxygen.value = it?.oxygen ?: 0
            }
        }
    }

    fun getChampyQuote(){
        viewModelScope.launch(Dispatchers.IO) {
            while (true){
                delay(Random.nextLong(3000, 5000))
                _champyQuote.value = getChampyHomeQuote(_userName.value)

                delay(5000)
                _champyQuote.value = null
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