package com.gg.spora.missions.domain.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gg.spora.missions.domain.UpdateMissionByIdUseCase
import com.gg.spora.missions.domain.enums.MissionType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MissionManager @Inject constructor(
    private val updateMissionByIdUseCase: UpdateMissionByIdUseCase,
) {
    private val scope = CoroutineScope(Dispatchers.Main)

    private val _missionCompleted = MutableStateFlow<Mission?>(null)
    val missionCompleted: StateFlow<Mission?> = _missionCompleted

    fun updateMission(missionType: MissionType) {
        scope.launch {
            _missionCompleted.value =
                updateMissionByIdUseCase(missionType.missionId)
        }
    }

    @Composable
    fun MissionPopUp(modifier: Modifier = Modifier) {

    }

}