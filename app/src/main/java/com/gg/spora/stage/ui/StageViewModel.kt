package com.gg.spora.stage.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.gg.spora.core.graph.NavigationRoutes
import com.gg.spora.core.utils.functions.getStageTypeByName
import com.gg.spora.stage.domain.GetLevelsUseCase
import com.gg.spora.stage.domain.model.GetStageLevelByStageTypeUseCase
import com.gg.spora.stage.domain.model.Level
import com.gg.spora.stage.domain.model.StageLevel
import com.gg.spora.user.domain.GetUserOxygenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StageViewModel @Inject constructor(
    private val getStageLevelByStageTypeUseCase: GetStageLevelByStageTypeUseCase,
    private val getLevelsUseCase: GetLevelsUseCase,
    private val getUserOxygenUseCase: GetUserOxygenUseCase,
    savedStateHandle: SavedStateHandle,
): ViewModel() {

    private val stageRoute = savedStateHandle.toRoute<NavigationRoutes.Stage>()

    private val _stage = MutableStateFlow<StageLevel?>(null)
    val stage = _stage.asStateFlow()

    private val _levels = MutableStateFlow<List<Level>>(emptyList())
    val levels = _levels.asStateFlow()

    private val _currentLevel = MutableStateFlow<Level?>(null)
    val currentLevel = _currentLevel.asStateFlow()

    private val _oxygen = MutableStateFlow(0)
    val oxygen = _oxygen.asStateFlow()

    init {
        getStage()
        getLevels()
        getOxygen()
    }

    private fun getOxygen() {
        viewModelScope.launch(Dispatchers.IO) {
            getUserOxygenUseCase().collect {
                _oxygen.value = it
            }
        }
    }

    private fun getLevels() {
        viewModelScope.launch(Dispatchers.IO) {
            getLevelsUseCase(getStageTypeByName(stageRoute.stageType)).collect {
                _levels.value = it
                _currentLevel.value = it.first()
            }
        }
    }

    private fun getStage(){
        viewModelScope.launch(Dispatchers.IO) {
            _stage.value = getStageLevelByStageTypeUseCase(getStageTypeByName(stageRoute.stageType))
        }
    }

    fun onLevelSelected(level: Level) {
        _currentLevel.value = level
    }

//    fun updateLevel(level: Level) {
//        stageRepository.updateLevel(level)
//    }


}