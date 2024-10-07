package com.gg.spora.challenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChallengeViewModel : ViewModel() {

    private val _objectsChallenge = MutableLiveData<Map<String, Boolean>>()
    val objectsChallenge: LiveData<Map<String, Boolean>> get() = _objectsChallenge
    private val _selectedObject = MutableLiveData<String>()
    val selectedObject: LiveData<String> get() = _selectedObject

    fun selectObject(objectName: String) {
        _selectedObject.value = objectName
    }

    fun setObjectsChallenge(objectsChallenge: Map<String, Boolean>) {
        _objectsChallenge.value = objectsChallenge
    }

    fun getObjectsChallenge(){
        _objectsChallenge.value = mapOf(
            "Botella de plastico" to false,
            "Caja de carton" to false,
            "Papel y Cartón" to false,
            "Envases de Plástico" to false,
        )
    }
}