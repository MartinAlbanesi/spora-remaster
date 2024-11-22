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
    private val insertInfoCardUseCase: InsertNewInfoCardUseCase,
    private val updateInfoCardUseCase: UpdateInfoCardUseCase,
    private val getInfoCardListByCategoryUseCase: GetInfoCardListByCategoryUseCase,
    private val infoCardRepositoryLocal: InfoCardRepositoryLocal,
    private val infoCardFakeRepository: FakeRepositoryInfoCard,
    private val updateMissionByIdUseCase: UpdateMissionByIdUseCase,
    val tutorialSelected: TutorialSelected
) : ViewModel() {

    private val _infoCardEntityList = MutableStateFlow<List<InfoCard>>(emptyList())
    val infoCardEntityList: StateFlow<List<InfoCard>> = _infoCardEntityList

    private val _missionCompleted = MutableStateFlow<Mission?>(null)
    val missionCompleted: StateFlow<Mission?> = _missionCompleted

    init {
        getLibraryTutorial()
        loadInfoCardList()
        updateMission()
    }

    private fun getLibraryTutorial() {
        tutorialSelected.getTutorial(Tutorials.LIBRARY_TUTORIAL)
    }

    private fun loadInfoCardList() {

        viewModelScope.launch {
            val currentInfoCards = getAllInfoCardsUseCase.invoke().first()
            _infoCardEntityList.value = currentInfoCards
        }

    }

    fun getInfoCardListByCategory(category: StageType) {
        viewModelScope.launch {
            _infoCardEntityList.value =
                getInfoCardListByCategoryUseCase.invoke(category.name).first()
        }
    }

    fun insertNewInfoCard(infoCard: InfoCard) {
        viewModelScope.launch {
            insertInfoCardUseCase.invoke(infoCard)
            loadInfoCardList()
        }
    }

    fun updateInfoCard(infoCard: InfoCard) {
        viewModelScope.launch {
            updateInfoCardUseCase.invoke(infoCard)
            loadInfoCardList()
        }
    }

    private fun updateMission() {
        viewModelScope.launch {
            _missionCompleted.value =
                updateMissionByIdUseCase(MissionType.LIBRARY_MISSION.missionId)
        }
    }

}
