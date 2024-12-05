package com.gg.spora.tutorials.domain

import android.util.Log
import com.gg.spora.core.utils.enums.Tutorials
import com.gg.spora.tutorials.data.TutorialModels
import com.gg.spora.tutorials.domain.model.TutorialItem
import com.gg.spora.tutorials.domain.repository.ITutorialRepositoryLocal
import com.gg.spora.user.domain.GetUserLocalUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

class TutorialSelected @Inject constructor(
    private val updateTutorialCompletedUseCase: UpdateTutorialCompletedUseCase,
    private val getUserLocalUseCase: GetUserLocalUseCase,
    private val tutorialRepositoryLocal: ITutorialRepositoryLocal,
) {

    private val scope = CoroutineScope(Dispatchers.Main)

    private var _currentTutorialIndex = 0

    private var _tutorialsItems: List<TutorialItem> = emptyList()

    private val _currentTutorialItem = MutableStateFlow<TutorialItem?>(null)
    val currentTutorialItem = _currentTutorialItem.asStateFlow()

    private val _showTutorial = MutableStateFlow(false)
    val showTutorial = _showTutorial.asStateFlow()

    private var tutorialType: Tutorials? = null

    private var _secondaryAction: () -> Unit = {}

    fun getTutorial(tutorial: Tutorials, secondaryAction: () -> Unit = {}) {
        scope.launch(Dispatchers.Main) {

            _secondaryAction = secondaryAction

            val isTutorialCompleted =
                tutorialRepositoryLocal.getTutorialById(tutorial.id)

            if (isTutorialCompleted.completed) {
                _showTutorial.value = false
                _secondaryAction()
                return@launch
            }


            tutorialType = tutorial

            val userName = getUserLocalUseCase().first()?.userName ?: ""

            _tutorialsItems = TutorialModels.getTutorial(tutorial, userName)

            _currentTutorialItem.value = _tutorialsItems.first()

            _showTutorial.value = true
        }
    }


    fun nextTutorialItem() {
        val nextIndex = _currentTutorialIndex + 1
        if (nextIndex < _tutorialsItems.size) {
            _currentTutorialIndex = nextIndex
            _currentTutorialItem.value = _tutorialsItems[nextIndex]
        } else {
            scope.launch {
                _showTutorial.value = false

                val userId = getUserLocalUseCase().first()?.id ?: ""
                updateTutorialCompletedUseCase(userId, tutorialType!!.id, true)
                _secondaryAction()
            }
        }
    }

    fun skipTutorial() {
        scope.launch(Dispatchers.Main) {
            _showTutorial.value = false

            val userId = getUserLocalUseCase().first()?.id ?: ""
            updateTutorialCompletedUseCase(userId, tutorialType!!.id, true)
            _secondaryAction()
        }
    }

}
