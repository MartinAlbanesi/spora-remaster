package com.gg.spora.welcome.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.core.fake.FakeStageModels
import com.gg.spora.core.utils.SporaConstant.BANNED_WORDS
import com.gg.spora.stage.domain.SetNewLevelsUseCase
import com.gg.spora.stage.domain.SetNewStagesLevelUseCase
import com.gg.spora.user.domain.SetNewUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val setNewUserUseCase: SetNewUserUseCase,
    private val setNewStagesLevelUseCase: SetNewStagesLevelUseCase,
    private val setNewLevelsUseCase: SetNewLevelsUseCase
) : ViewModel() {

    private val _guestName = MutableStateFlow("")

    init {
        setNewDataInApp()
    }

    fun setGuestName(name: String) {
        viewModelScope.launch {
            _guestName.value =
                name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
        }
    }

    fun filterBannedWords(text: String, bannedWords: List<String> = BANNED_WORDS): String {
        var filteredText = text
        for (word in bannedWords) {
            filteredText = filteredText.replace(
                word, "*".repeat(word.length),
                ignoreCase = true
            )
        }
        return filteredText
    }

    fun setNewUser() {
        viewModelScope.launch {
            setNewUserUseCase(null, _guestName.value)
        }
    }

    private fun setNewDataInApp() {
        viewModelScope.launch(Dispatchers.IO) {
            val level = FakeStageModels.fakeLevels
            val stageLevel = FakeStageModels.fakeStage
            setNewStagesLevelUseCase(stageLevel)
            setNewLevelsUseCase(level)
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
