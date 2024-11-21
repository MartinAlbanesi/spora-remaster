package com.gg.spora.library.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.Tutorials
import com.gg.spora.library.data.repository.FakeRepositoryInfoCard
import com.gg.spora.library.data.repository.InfoCardRepositoryLocal
import com.gg.spora.library.domain.mappers.toInfoCard
import com.gg.spora.library.domain.model.InfoCard
import com.gg.spora.missions.domain.UpdateMissionByIdUseCase
import com.gg.spora.missions.domain.enums.MissionType
import com.gg.spora.tutorials.data.TutorialModels
import com.gg.spora.tutorials.data.TutorialModels.getLibraryTutorial
import com.gg.spora.tutorials.domain.TutorialSelected
import com.gg.spora.tutorials.domain.UpdateTutorialCompletedUseCase
import com.gg.spora.tutorials.domain.model.TutorialItem
import com.gg.spora.tutorials.domain.repository.ITutorialRepositoryLocal
import com.gg.spora.user.domain.GetUserLocalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val infoCardRepositoryLocal: InfoCardRepositoryLocal,
    private val infoCardFakeRepository: FakeRepositoryInfoCard,
    private val updateMissionByIdUseCase: UpdateMissionByIdUseCase,
    val tutorialSelected: TutorialSelected
) : ViewModel() {

    private val _infoCardEntityList = MutableStateFlow<List<InfoCard>>(emptyList())
    val infoCardEntityList: StateFlow<List<InfoCard>> = _infoCardEntityList

    init {
        getLibraryTutorial()
        loadInfoCardList()
        updateMission()
    }

    private fun getLibraryTutorial(){
        tutorialSelected.getTutorial(Tutorials.LIBRARY_TUTORIAL)
    }

    private fun loadInfoCardList() {

        viewModelScope.launch {
            val currentInfoCards =
                infoCardRepositoryLocal.getAllInfoCards().first() // Get initial data
            _infoCardEntityList.value = currentInfoCards

            if (currentInfoCards.isEmpty()) {
                infoCardFakeRepository.getAllInfoCards().forEach {
                    infoCardRepositoryLocal.insertInfoCard(it.toInfoCard())
                }
                Log.d("LibraryViewModel", "Fake data inserted")
                // Refresh the list after inserting fake data
                _infoCardEntityList.value = infoCardRepositoryLocal.getAllInfoCards().first()
            }
        }
    }

    fun getInfoCardListByCategory(category: StageType) {
        viewModelScope.launch {
            infoCardRepositoryLocal.getInfoCardListByCategory(category.name).collect {
                _infoCardEntityList.value = it
            }
        }
    }

    private fun updateMission(){
        viewModelScope.launch {
            updateMissionByIdUseCase(MissionType.LIBRARY_MISSION.missionId)
        }
    }

//    fun unlockInfoCard(infoCardEntity: InfoCardEntity) {
//        viewModelScope.launch {
//            infoCardEntity.isUnlocked = true
//            infoCardRepositoryLocal.updateInfoCard(infoCardEntity.toInfoCard())
//        }
//    }
//
//    private fun searchInfoCardById(id: Int): InfoCard? {
//        var auxInfoCardEntity: InfoCard? = null
//
//        try {
//            viewModelScope.launch {
//                auxInfoCardEntity = infoCardRepositoryLocal.getInfoCardById(id)
//            }
//        } catch (e: Exception) {
////            e.printStackTrace()
//        }
//        return auxInfoCardEntity
//    }
}