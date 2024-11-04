package com.gg.spora.forestStage.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.gg.spora.core.graph.NavigationRoutes
import com.gg.spora.core.utils.functions.getStageTypeByName
import com.gg.spora.forestStage.domain.GetLevelsUseCase
import com.gg.spora.forestStage.domain.IStageRepositoryLocal
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.forestStage.domain.model.StageLevel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StageViewModel @Inject constructor(
    private val stageRepository: IStageRepositoryLocal,
    private val getLevelsUseCase: GetLevelsUseCase,
    savedStateHandle: SavedStateHandle,
): ViewModel() {

    private val stageRoute = savedStateHandle.toRoute<NavigationRoutes.Stage>()

    private val _stage = MutableStateFlow<StageLevel?>(null)
    val stage = _stage.asStateFlow()

    private val _levels = MutableStateFlow<List<Level>>(emptyList())
    val levels = _levels.asStateFlow()

    private val _currentLevel = MutableStateFlow<Level?>(null)
    val currentLevel = _currentLevel.asStateFlow()

    init {
        getStage()
        getLevels()
        getCurrentLevel()
    }

    private fun getLevels() {
        viewModelScope.launch(Dispatchers.IO) {
            getLevelsUseCase(getStageTypeByName(stageRoute.stageType)).collect {
                _levels.value = it
            }
        }
    }

    private fun getStage(){
        _stage.value = stageRepository.getStage(getStageTypeByName(stageRoute.stageType))
    }

    private fun getCurrentLevel() {
        _currentLevel.value = _levels.value.first()
    }

    fun onLevelSelected(level: Level) {
        _currentLevel.value = level
    }

//    fun updateLevel(level: Level) {
//        stageRepository.updateLevel(level)
//    }


}