package com.gg.spora.forestStage.ui

import androidx.lifecycle.ViewModel
import com.gg.spora.core.utils.enums.TypeStage
import com.gg.spora.forestStage.domain.IStageRepository
import com.gg.spora.forestStage.domain.model.Level
import com.gg.spora.forestStage.domain.model.StageLevel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class StageViewModel @Inject constructor(
    private val stageRepository: IStageRepository
): ViewModel() {

    private val _stage = MutableStateFlow<StageLevel?>(null)
    val stage = _stage.asStateFlow()

//    private val _levels = MutableStateFlow<List<Level>>(emptyList())
//    val levels = _levels.asStateFlow()

    private val _currentLevel = MutableStateFlow<Level?>(null)
    val currentLevel = _currentLevel.asStateFlow()

    init {
//        getLevels()
        getStage()
        getCurrentLevel()
    }

    private fun getStage(){
        _stage.value = stageRepository.getStage(TypeStage.FOREST)
    }

    private fun getCurrentLevel() {
        _currentLevel.value = _stage.value?.levels?.first()
    }

//    private fun getLevels() {
//        _levels.value = stageRepository.getLevels(TypeStage.FOREST)
//    }

    fun onLevelSelected(level: Level) {
        _currentLevel.value = level
    }

    fun updateLevel(level: Level) {
        stageRepository.updateLevel(level)
    }


}