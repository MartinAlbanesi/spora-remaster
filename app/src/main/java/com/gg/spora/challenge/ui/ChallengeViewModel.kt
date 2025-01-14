package com.gg.spora.challenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.challenge.domain.GetAllObjectsDetailOfForestChallengeUseCase
import com.gg.spora.challenge.domain.PutObjectDetailLocalUseCase
import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.core.fake.FakeChallengeModels
import com.gg.spora.grove.domain.InsertSeedTreeUseCase
import com.gg.spora.grove.domain.models.SeedTree
import com.gg.spora.grove.domain.models.TreeType
import com.gg.spora.user.domain.GetAllObjectsDetailForUserUseCase
import com.gg.spora.user.domain.UpdateObjectDetailChallengeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChallengeViewModel @Inject constructor(
    private val putObjectDetailLocalUseCase: PutObjectDetailLocalUseCase,
    private val updateObjectDetailChallengeUseCase : UpdateObjectDetailChallengeUseCase,
    private val getAllObjectsDetailForUserUseCase : GetAllObjectsDetailForUserUseCase,
    private val insertSeedTreeUseCase: InsertSeedTreeUseCase,
//    private val getAllObjectsDetailOfForestChallengeUseCase: GetAllObjectsDetailOfForestChallengeUseCase
) : ViewModel () {

    private val _objectsChallenge = MutableLiveData<List<ObjectDetail>>(mutableListOf())
    val objectsChallenge: LiveData<List<ObjectDetail>> = _objectsChallenge

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _isFinally = MutableLiveData(false)
    val isFinally: LiveData<Boolean> get() = _isFinally

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

    fun insertSeedTreeOfChallengeOne(){
        viewModelScope.launch {
            val seedTree = SeedTree(type = TreeType.PINE)
            insertSeedTreeUseCase(seedTree)
        }
    }

    fun setObjectInObjectsChallengeWithName(nameObjectDetail: String) {
        viewModelScope.launch {
            updateObjectDetailChallengeUseCase(nameObjectDetail)

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
            val listObjectsDatabase = getAllObjectsDetailForUserUseCase()

            if(listObjectsDatabase.isEmpty()){
                for(objectDetail in listObjects){
                    putObjectDetailLocalUseCase(objectDetail)
                }
                _objectsChallenge.postValue(listObjects)
            }
            else{
                _objectsChallenge.postValue(listObjectsDatabase)
            }
            setLoading(false)
        }

    }

    private fun setLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }
}