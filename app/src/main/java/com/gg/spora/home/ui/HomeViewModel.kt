package com.gg.spora.home.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.Tutorials
import com.gg.spora.home.domain.functions.getChampyHomeQuote
import com.gg.spora.tutorials.domain.TutorialSelected
import com.gg.spora.user.domain.GetUserAuthUseCase
import com.gg.spora.user.domain.GetUserLocalUseCase
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
    private val getUserLocalUseCase: GetUserLocalUseCase,
    private val getUserAuthUseCase: GetUserAuthUseCase,
    val tutorialSelected: TutorialSelected
) : ViewModel() {

    private val _oxygen = MutableStateFlow(0)
    val oxygen = _oxygen.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val _champyQuote = MutableStateFlow<String?>(null)
    val champyQuote = _champyQuote.asStateFlow()

    private var _user = MutableStateFlow<User?>(null)
    val user = _user.asStateFlow()

    private var hasShowWelcomeMessage = false

    private val _isUserLoggedIn = MutableStateFlow(false)
    val isUserLoggedIn = _isUserLoggedIn.asStateFlow()

    init {
//        getUser()
        getUserName()
//        getTutorial(Tutorials.HOME_TUTORIAL)
        tutorialSelected.getTutorial(Tutorials.HOME_TUTORIAL)
        getOxygen()
        getChampyQuote()
    }

    private fun getUserName() {
        viewModelScope.launch {
            getUserLocalUseCase().collect {
                _user.value = it
            }

            _isUserLoggedIn.value = getUserAuthUseCase() != null
        }
    }

    fun getTutorial(tutorials: Tutorials, secondaryAction: () -> Unit) {
        viewModelScope.launch {
            tutorialSelected.getTutorial(tutorials, secondaryAction)
        }
    }


    private fun getOxygen() {
        viewModelScope.launch {
            getUserLocalUseCase().collect {
                _oxygen.value = it?.oxygen ?: 0
            }
        }
    }

    private fun getChampyQuote() {
        viewModelScope.launch(Dispatchers.Main) {
            while (true) {
                delay(Random.nextLong(3000, 5000))
                _champyQuote.value = if (!hasShowWelcomeMessage) {
                    hasShowWelcomeMessage = true
                    getChampyHomeQuote(_user.value?.userName ?: "")
                } else {
                    SporaConstant.CHAMPY_RANDOM_QUOTE.random()
                }

                delay(7000)
                _champyQuote.value = null
            }
        }
    }

}