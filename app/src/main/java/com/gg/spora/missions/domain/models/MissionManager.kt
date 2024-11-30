package com.gg.spora.missions.domain.models

import com.gg.spora.missions.domain.UpdateMissionByIdUseCase
import com.gg.spora.missions.domain.enums.MissionType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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

            delay(7000)
            _missionCompleted.value = null
        }
    }
}