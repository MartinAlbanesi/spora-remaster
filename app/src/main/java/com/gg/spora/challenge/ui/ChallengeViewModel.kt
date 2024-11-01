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
        getObjectsValidate()
    }

    fun selectObject(objectName: String) {
        viewModelScope.launch {
            _objectsChallenge.value?.add(ObjectDetail(objectName, "", true))
            _selectedObject.value = objectName
        }
    }

    fun setEmptySelectedObject(){
        _selectedObject.value = ""
    }

    fun setObjectsChallengeEmpty(){
        val currentList = _objectsChallenge.value ?: mutableListOf()

        val updatedList = currentList.map { objectDetail ->
            objectDetail.copy(isValidate = false)
        }.toMutableList()

        _objectsChallenge.value = updatedList
    }

    private fun getObjectsValidate() {
        viewModelScope.launch {
            val currentList = _objectsChallenge.value ?: mutableListOf()
            val listData = challengeRepository.getAllObjectsDetail()

            for (objectChallenge in listData) {
                val matchingObject = currentList.find { it.nameObjectDetail == objectChallenge.nameObjectDetail }
                if (matchingObject != null) {
                    matchingObject.isValidate = true
                }
            }

            _objectsChallenge.value = currentList
        }
    }

    fun setObjectInObjectsChallengeWithName(nameObjectDetail: String) {
        viewModelScope.launch {
            challengeRepository.setValidObjectDetailInDatabase(nameObjectDetail)

            val currentList = _objectsChallenge.value ?: mutableListOf()
            val objectToModify = currentList.find { it.nameObjectDetail == nameObjectDetail }

            objectToModify?.let {
                it.isValidate = true
            }

            _objectsChallenge.value = currentList
        }
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
        viewModelScope.launch{
            val listObjects = mutableListOf(
                ObjectDetail(
                    "Botella de plástico",
                    "Muchas botellas de plástico se pueden reciclar, y seguro que encontras varias en casa. ¡Aprovechemos y cuidemos el planeta reciclando!",
                    false,
                    mutableListOf(StepObjectDetail( 1,"Limpieza",
                        "Vacíá y limpiá las botellas: enjuagalas con agua y un poquito de detergente para dejarlas listas para reciclar.",
                        true, false),
                        StepObjectDetail( 2,"Validación",
                            "Una botella de plástico que se puede reciclar debe tener un ícono de reciclaje. ¡Buscá el símbolo antes de desecharla!"),
                        StepObjectDetail( 3,"Reciclado",
                            "Si la botella es reciclable, ¡podés ponerla en los contenedores de reciclaje para que tenga una nueva vida!"),
                        StepObjectDetail(4,"Crear",
                            "Si la botella no es reciclable, ¡no te preocupes! Podés reutilizarla para hacer manualidades o crear objetos decorativos y divertidos.",
                            false, true))
                ),
                ObjectDetail(
                    "Caja de cartón",
                    "Al reutilizar el cartón, ¡estamos cuidando el planeta y a nuestros amigos los árboles!",
                    false,
                    mutableListOf(StepObjectDetail( 1,"Limpieza",
                        "Asegurate de que la caja de cartón esté limpia y libre de cualquier elemento que pueda interferir con su reciclaje.",true, false),
                        StepObjectDetail( 2,"Recortar",
                            "Con la ayuda de un adulto, cortá la caja de cartón en pequeños trozos."),
                        StepObjectDetail( 3,"Crear",
                            "Con estos pequeños trozos de cartón, ¡podés crear manualidades divertidas y darle una nueva vida al cartón!",false, true))
                ),
                ObjectDetail(
                    "Tapita de plástico",
                    "Las tapitas de plástico están en todos lados, ¡y reciclarlas es muy fácil!",
                    false,
                    mutableListOf(StepObjectDetail( 1,"Juntar",
                        "Reuní tapitas plásticas de gaseosas, aguas, juegos y productos de limpieza, ¡esas son las que se pueden reciclar!",true, false),
                        StepObjectDetail( 2,"Limpieza",
                            "Lavá las tapitas para eliminar cualquier residuo de líquidos o suciedad que pueda afectar el reciclaje."),
                        StepObjectDetail( 3,"Crear o llevar",
                            "Podés usar las tapitas para hacer decoraciones creativas o llevarlas a una planta de reciclaje. ¡Ellos sabrán qué hacer!",false, true))
                ),
                ObjectDetail(
                    "Latas de aluminio",
                    "Las tapitas de plástico están en todos lados, ¡y reciclarlas es muy fácil!",
                    false,
                    mutableListOf(StepObjectDetail( 1,"Juntar",
                        "Reuní tapitas plásticas de gaseosas, aguas, juegos y productos de limpieza, ¡esas son las que se pueden reciclar!",true, false),
                        StepObjectDetail( 2,"Limpieza",
                            "Lavá las tapitas para eliminar cualquier residuo de líquidos o suciedad que pueda afectar el reciclaje."),
                        StepObjectDetail( 3,"Crear o llevar",
                            "Podés usar las tapitas para hacer decoraciones creativas o llevarlas a una planta de reciclaje. ¡Ellos sabrán qué hacer!",false, true))
                )
            )

            for(objectDetail in listObjects){
                challengeRepository.insertObjectDetail(objectDetail)
            }
        }

    }
}