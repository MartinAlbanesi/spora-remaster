package com.gg.spora.library.ui

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.gg.spora.core.graph.NavigationRoutes
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.core.utils.enums.Tutorials
import com.gg.spora.library.data.repository.FakeRepositoryInfoCard
import com.gg.spora.library.data.repository.InfoCardRepositoryLocal
import com.gg.spora.library.domain.mappers.toInfoCard
import com.gg.spora.library.domain.model.InfoCard
import com.gg.spora.tutorials.data.TutorialModels
import com.gg.spora.tutorials.data.TutorialModels.getLibraryTutorial
import com.gg.spora.tutorials.domain.UpdateTutorialCompletedUseCase
import com.gg.spora.tutorials.domain.model.TutorialItem
import com.gg.spora.tutorials.domain.repository.ITutorialRepositoryLocal
import com.gg.spora.user.domain.GetUserLocalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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
    private val tutorialRepositoryLocal: ITutorialRepositoryLocal,
    private val getUserLocalUseCase: GetUserLocalUseCase,
    private val updateTutorialCompletedUseCase: UpdateTutorialCompletedUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _libraryRoute = savedStateHandle.toRoute<NavigationRoutes.Library>()

    private val _showTutorial = MutableStateFlow(true)
    val showTutorial = _showTutorial.asStateFlow()

    private var _libraryTutorial: List<TutorialItem> = emptyList()

    private var _currentTutorialIndex = 0

    private val _currentTutorialItem = MutableStateFlow<TutorialItem?>(null)
    val currentTutorialItem = _currentTutorialItem.asStateFlow()

    private val _infoCardEntityList = MutableStateFlow<List<InfoCard>>(emptyList())
    val infoCardEntityList: StateFlow<List<InfoCard>> = _infoCardEntityList

    init {
        getLibraryTutorial()
        loadInfoCardList()
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

    private fun getLibraryTutorial() {

        viewModelScope.launch {
            val isTutorialCompleted =
                tutorialRepositoryLocal.getTutorialById(Tutorials.LIBRARY_TUTORIAL.id)

            if (isTutorialCompleted.isCompleted) {
                _showTutorial.value = false
                return@launch
            }

            val userName = getUserLocalUseCase().first()?.userName ?: ""
            _libraryTutorial = getLibraryTutorial(userName)

            _currentTutorialItem.value = _libraryTutorial.first()
        }
    }

    fun nextTutorialItem() {
        val nextIndex = _currentTutorialIndex + 1
        if (nextIndex < _libraryTutorial.size) {
            _currentTutorialIndex = nextIndex
            _currentTutorialItem.value = _libraryTutorial[nextIndex]
        } else {
            viewModelScope.launch {
                _showTutorial.value = false

                val userId = getUserLocalUseCase().first()?.id ?: ""
                updateTutorialCompletedUseCase(userId, Tutorials.LIBRARY_TUTORIAL.id, true)
            }
        }
    }

    fun skipTutorial() {
        viewModelScope.launch {
            _showTutorial.value = false

            val userId = getUserLocalUseCase().first()?.id ?: ""
            updateTutorialCompletedUseCase(userId, Tutorials.LIBRARY_TUTORIAL.id, true)
        }
    }
}