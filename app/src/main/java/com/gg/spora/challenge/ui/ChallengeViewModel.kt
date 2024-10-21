package com.gg.spora.challenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.challenge.data.repositories.ChallengeRepository
import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.challenge.domain.model.StepObjectDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChallengeViewModel @Inject constructor(val challengeRepository: ChallengeRepository) : ViewModel () {

    private val _objectsChallenge = MutableLiveData<MutableList<ObjectDetail>>()
    val objectsChallenge: LiveData<MutableList<ObjectDetail>> = _objectsChallenge

    private val _selectedObject = MutableLiveData<String>()
    val selectedObject: LiveData<String> get() = _selectedObject

    init {
        // Cargar los objetos desafío desde la base de datos
        //loadObjectsChallenge()
        insertObjectsDetailInDatabase()
        insertStepsObjectDetailInDatabase()
        loadObjectsChallenge()
    }

    fun selectObject(objectName: String) {
        _selectedObject.value = objectName
    }

    fun setValidObjectDetailInDatabase(idObjectDetail: Int) {
        viewModelScope.launch {
            challengeRepository.setValidObjectDetailInDatabase(idObjectDetail)
            //_objectsChallenge.value?.put(selectedValue, true)
        }
    }

    private fun loadObjectsChallenge() {
        viewModelScope.launch{
            _objectsChallenge.value = challengeRepository.getAllObjectsDetail().toMutableList()
        }
    }

    private fun getStepsObjectsChallenge(idObjectDetail: Int) : List<StepObjectDetail> {
        var listSteps = listOf<StepObjectDetail>()
        viewModelScope.launch{
            listSteps =  challengeRepository.getAllStepsObjectDetailWithId(idObjectDetail)
        }
        return listSteps
    }

    private fun insertObjectsDetailInDatabase(){
        viewModelScope.launch{
            val listObjects = mutableListOf(
                ObjectDetail(
                    1,
                    "Botella de plástico",
                    "Muchas botellas de plástico son reciclables y se pueden encontrar por cualquier parte de la casa.",
                    false
                ),
                ObjectDetail(
                    2,
                    "Caja de carton",
                    "Al reutilizar el carton cuidamos al planeta y a nuestros amigos los arboles!",
                    false
                ),
                ObjectDetail(
                    3,
                    "Tapitas de botella",
                    "Las tapitas de plastico se pueden encontrar por cualquier lado y su reciclaje es muy facil!.",
                    false
                )
            )

            for(objectDetail in listObjects){
                challengeRepository.insertObjectDetail(objectDetail)
            }
        }
    }

    private fun insertStepsObjectDetailInDatabase(){
        viewModelScope.launch {
            val listSteps = mutableListOf(
                StepObjectDetail(1, 1,"Limpieza",
                "Vaciá y limpiá las botellas enjuagándolas " +
                        "con agua y unas gotitas de detergente.",
                true, false),
                StepObjectDetail(1, 2,"Validación",
                    "Una botella de plástico que se puede " +
                            "reciclar debera tener un ícono de reciclaje. "),
                StepObjectDetail(1, 3,"Reciclado",
                    "Si la botella se puede reciclar entonces se " +
                            "puede ingresar en los contenedores de reciclado."),
                StepObjectDetail(1, 4,"Crear",
                    "Si no se pueda reciclar, entonces se pueden hacer " +
                            "manualidades u objetos de decoración con los materiales.",
                    false, true),
                StepObjectDetail(2, 1,"Limpieza",
                    "Asegurate que la caja de Carton este limpia " +
                            "y sin ningun elemento que pueda interferir con su reciclaje",true, false),
                StepObjectDetail(2, 2,"Recortar",
                    "Acompañado de un adulto, recorta la caja de carton en pequeños trozos"),
                StepObjectDetail(2, 3,"Crear",
                    "Con estos pequeños trozos de carton podes " +
                            "hacer manualidades divertidas.",false, true))
            for(step in listSteps){
                challengeRepository.insertStepObjectDetail(step)
            }
        }
    }
}