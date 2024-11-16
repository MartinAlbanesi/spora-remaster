package com.gg.spora.challenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.challenge.data.local.ChallengeRepositoryLocal
import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.core.fake.FakeChallengeModels
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChallengeViewModel @Inject constructor(private val challengeRepositoryLocal: ChallengeRepositoryLocal) : ViewModel () {

    private val _objectsChallenge = MutableLiveData<List<ObjectDetail>>(mutableListOf())
    val objectsChallenge: LiveData<List<ObjectDetail>> = _objectsChallenge

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {
        insertObjectsDetailInDatabase()
    }

    fun setObjectsChallengeEmpty(){
        val currentList = _objectsChallenge.value ?: mutableListOf()

        val updatedList = currentList.map { objectDetail ->
            objectDetail.copy(isValidate = false)
        }.toMutableList()

        _objectsChallenge.postValue(updatedList)
    }

    fun getObjectDetailWithName(nameObjectDetail : String) : ObjectDetail{
        var objectDetail = ObjectDetail( "", "",false)

        for(objectDetailList in objectsChallenge.value!!){
            if(objectDetailList.nameObjectDetail == nameObjectDetail){
                objectDetail =  objectDetailList
            }

        }
        return objectDetail
    }

    private fun getObjectsInDatabase() {
        viewModelScope.launch {

            val currentList = challengeRepositoryLocal.getAllObjectsDetail()

            if(currentList.isNotEmpty()){
                for(objectChallenge in currentList){
                    objectChallenge.stepsObjectDetail = challengeRepositoryLocal.getAllStepsObjectDetailWithName(objectChallenge.nameObjectDetail!!)
                }
                _objectsChallenge.postValue(currentList)
            }
            setLoading(false)
        }
    }

    fun setObjectInObjectsChallengeWithName(nameObjectDetail: String) {
        viewModelScope.launch {
            challengeRepositoryLocal.setValidObjectDetailInDatabase(nameObjectDetail)

            val currentList = _objectsChallenge.value ?: mutableListOf()
            val objectToModify = currentList.find { it.nameObjectDetail == nameObjectDetail }

            objectToModify?.let {
                it.isValidate = true
            }

            _objectsChallenge.postValue(currentList)
        }
    }

    private fun insertObjectsDetailInDatabase(){
        viewModelScope.launch{
            val listObjects = FakeChallengeModels.fakeObjectDetails

            for(objectDetail in listObjects){
                challengeRepositoryLocal.setObjectDetail(objectDetail)
                challengeRepositoryLocal.insertStepsObjectDetail(objectDetail.stepsObjectDetail)
            }
            getObjectsInDatabase()

        }

    }

    fun setLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }
}