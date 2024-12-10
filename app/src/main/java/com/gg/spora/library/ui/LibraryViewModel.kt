package com.gg.spora.library.ui

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
import com.gg.spora.missions.domain.models.Mission
import com.gg.spora.tutorials.data.TutorialModels
import com.gg.spora.tutorials.data.TutorialModels.getLibraryTutorial
import com.gg.spora.tutorials.domain.TutorialSelected
import com.gg.spora.tutorials.domain.UpdateTutorialCompletedUseCase
import com.gg.spora.tutorials.domain.model.TutorialItem
import com.gg.spora.tutorials.domain.repository.ITutorialRepositoryLocal
import com.gg.spora.user.domain.GetUserLocalUseCase
import com.gg.spora.library.domain.usecases.GetAllInfoCardsUseCase
import com.gg.spora.library.domain.usecases.GetInfoCardListByCategoryUseCase
import com.gg.spora.library.domain.usecases.InsertNewInfoCardUseCase
import com.gg.spora.library.domain.usecases.UpdateInfoCardUseCase
import com.gg.spora.missions.domain.models.MissionManager
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
    private val getAllInfoCardsUseCase: GetAllInfoCardsUseCase,
//    private val insertInfoCardUseCase: InsertNewInfoCardUseCase,
//    private val updateInfoCardUseCase: UpdateInfoCardUseCase,
    private val getInfoCardListByCategoryUseCase: GetInfoCardListByCategoryUseCase,
//    private val infoCardRepositoryLocal: InfoCardRepositoryLocal,
//    private val infoCardFakeRepository: FakeRepositoryInfoCard,
    val tutorialSelected: TutorialSelected,
    val missionManager: MissionManager
) : ViewModel() {

    private val _infoCardEntityList = MutableStateFlow<List<InfoCard>>(emptyList())
    val infoCardEntityList: StateFlow<List<InfoCard>> = _infoCardEntityList

    private val _showDialog = MutableStateFlow(false)
    val showDialog: StateFlow<Boolean> = _showDialog

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        getLibraryTutorial()
        loadInfoCardList()
        missionManager.updateMission(MissionType.LIBRARY_MISSION)
    }

    private fun getLibraryTutorial() {
        tutorialSelected.getTutorial(Tutorials.LIBRARY_TUTORIAL)
    }

    private fun loadInfoCardList() {
        try {
            viewModelScope.launch {
                val currentInfoCards = getAllInfoCardsUseCase.invoke().first()
                _infoCardEntityList.value = currentInfoCards

                _isLoading.value = false
            }
        }catch (e: Exception){
            e.printStackTrace()
            _isLoading.value = false
        }

    }

    fun getInfoCardListByCategory(category: StageType) {
        viewModelScope.launch {
            _showDialog.value = true
            _infoCardEntityList.value =
                getInfoCardListByCategoryUseCase.invoke(category.name).first()
        }
    }

    fun showDialog() {
        _showDialog.value = !_showDialog.value
    }
//
//    fun insertNewInfoCard(infoCard: InfoCard) {
//        viewModelScope.launch {
//            insertInfoCardUseCase.invoke(infoCard)
//            loadInfoCardList()
//        }
//    }
//
//    fun updateInfoCard(infoCard: InfoCard) {
//        viewModelScope.launch {
//            updateInfoCardUseCase.invoke(infoCard)
//            loadInfoCardList()
//        }
//    }

}
