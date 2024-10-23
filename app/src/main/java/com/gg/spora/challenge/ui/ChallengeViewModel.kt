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
class ChallengeViewModel @Inject constructor(private val challengeRepository: ChallengeRepository) : ViewModel () {

    private val _objectsChallenge = MutableLiveData<MutableList<ObjectDetail>>(mutableListOf())
    val objectsChallenge: LiveData<MutableList<ObjectDetail>> = _objectsChallenge

    private val _selectedObject = MutableLiveData<String>()
    val selectedObject: LiveData<String> get() = _selectedObject

    init {
        insertObjectsDetailInDatabase()
        //loadObjectsChallenge()
    }

    fun selectObject(objectName: String) {
        _selectedObject.value = objectName
    }

    fun setEmptySelectedObject(){
        _selectedObject.value = ""
    }

    fun setObjectInObjectsChallengeWithName(nameObjectDetail: String) {
        viewModelScope.launch {

            val currentList = _objectsChallenge.value ?: mutableListOf()

            val objectToModify = currentList.find { it.nameObjectDetail == nameObjectDetail }

            objectToModify?.let {
                it.isValidate = true
            }

            _objectsChallenge.value = currentList
            challengeRepository.setValidObjectDetailInDatabase(nameObjectDetail)
        }
    }

    private fun loadObjectsChallenge() {
        viewModelScope.launch{
            _objectsChallenge.value = challengeRepository.getAllObjectsDetail().toMutableList()
        }
    }

    private fun getStepsObjectsChallenge(nameObjectDetail: String) : List<StepObjectDetail> {
        var listSteps = listOf<StepObjectDetail>()
        viewModelScope.launch{
            listSteps =  challengeRepository.getAllStepsObjectDetailWithName(nameObjectDetail)
        }
        return listSteps
    }

    fun getObjectDetailWithName(objectDetailName : String) : ObjectDetail{
        var objectDetail = ObjectDetail( "", "",false)

        for(objectDetailList in objectsChallenge.value!!){
            if(objectDetailList.nameObjectDetail == objectDetailName){
                objectDetail =  objectDetailList
            }
        }
        return objectDetail
    }

    private fun insertObjectsDetailInDatabase(){
            val listObjects = mutableListOf(
                ObjectDetail(
                    "Botella de plástico",
                    "Muchas botellas de plástico son reciclables y se pueden encontrar por cualquier parte de la casa.",
                    false,
                    mutableListOf(StepObjectDetail( 1,"Limpieza",
                        "Vaciá y limpiá las botellas enjuagándolas " +
                                "con agua y unas gotitas de detergente.",
                        true, false),
                        StepObjectDetail( 2,"Validación",
                            "Una botella de plástico que se puede " +
                                    "reciclar debera tener un ícono de reciclaje. "),
                        StepObjectDetail( 3,"Reciclado",
                            "Si la botella se puede reciclar entonces se " +
                                    "puede ingresar en los contenedores de reciclado."),
                        StepObjectDetail(4,"Crear",
                            "Si no se pueda reciclar, entonces se pueden hacer " +
                                    "manualidades u objetos de decoración con los materiales.",
                            false, true))
                ),
                ObjectDetail(
                    "Caja de carton",
                    "Al reutilizar el carton cuidamos al planeta y a nuestros amigos los arboles!",
                    false,
                    mutableListOf(StepObjectDetail( 1,"Limpieza",
                        "Asegurate que la caja de Carton este limpia " +
                                "y sin ningun elemento que pueda interferir con su reciclaje",true, false),
                        StepObjectDetail( 2,"Recortar",
                            "Acompañado de un adulto, recorta la caja de carton en pequeños trozos"),
                        StepObjectDetail( 3,"Crear",
                            "Con estos pequeños trozos de carton podes " +
                                    "hacer manualidades divertidas.",false, true))
                ),
                ObjectDetail(
                    "Tapita de plástico",
                    "Las tapitas de plastico se pueden encontrar por cualquier lado y su reciclaje es muy facil",
                    false,
                    mutableListOf(StepObjectDetail( 1,"Juntar",
                        "Juntá tapitas plásticas de gaseosas, aguas, juegos " +
                                "y productos de limpieza que son las que se reciclan.",true, false),
                        StepObjectDetail( 2,"Limpieza",
                            "Lava las tapitas para sacar residuos de líquidos o " +
                                    "cualquier tipo de suciedad que pueda afectar el reciclado"),
                        StepObjectDetail( 3,"Crear o llevar",
                            "Puedes usar las tapitas para hacer decoraciones o " +
                                    "llevarlas a una planta de reciclaje. ¡Ellos sabran que hacer!",false, true))
                )
            )

            for(objectDetail in listObjects){
                _objectsChallenge.value?.add(objectDetail)
                //challengeRepository.insertObjectDetail(objectDetail)
            }

    }
}