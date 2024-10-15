package com.gg.spora.challenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChallengeViewModel @Inject constructor() : ViewModel () {

    private val _objectsChallenge = MutableLiveData<MutableMap<String, Boolean>>()
    val objectsChallenge: LiveData<MutableMap<String, Boolean>> = _objectsChallenge

    private val _selectedObject = MutableLiveData<String>()
    val selectedObject: LiveData<String> get() = _selectedObject

    init {
        setObjectsChallengeData()
    }

    fun selectObject(objectName: String) {
        _selectedObject.value = objectName
    }

    fun setObjectInObjectsChallenge() {
        val currentMap = _objectsChallenge.value ?: mutableMapOf()
        val selectedValue = _selectedObject.value
        selectedValue?.let {
            currentMap[it] = true
            _objectsChallenge.value = currentMap
        }
    }

    private fun setObjectsChallengeData() {
        _objectsChallenge.value = mutableMapOf(
            "Botella de plastico" to false,
            "Caja de carton" to false,
        )
    }
}