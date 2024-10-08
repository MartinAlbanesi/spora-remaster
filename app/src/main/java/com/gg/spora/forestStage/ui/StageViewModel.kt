package com.gg.spora.forestStage.ui

import androidx.lifecycle.ViewModel
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.forestStage.domain.IStageRepository
import com.gg.spora.forestStage.domain.model.Level
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class StageViewModel @Inject constructor(
    private val stageRepository: IStageRepository
): ViewModel() {

    private val _levels = MutableStateFlow(stageRepository.getLevels(StageType.FOREST))
    val levels = _levels.asStateFlow()

    private val _currentLevel = MutableStateFlow<Level?>(null)
    val currentLevel = _currentLevel.asStateFlow()

    init {
        getLevels()
        getCurrentLevel()
    }

    private fun getCurrentLevel() {
        _currentLevel.value = _levels.value.first()
    }

    private fun getLevels() {
        _levels.value = stageRepository.getLevels(StageType.FOREST)
    }

    fun onLevelSelected(level: Level) {
        _currentLevel.value = level
    }


}