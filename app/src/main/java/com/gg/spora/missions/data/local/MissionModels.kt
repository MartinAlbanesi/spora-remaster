package com.gg.spora.missions.data.local

import com.gg.spora.missions.domain.enums.MissionType
import com.gg.spora.missions.domain.models.Mission

object MissionModels {

    val missions = listOf(
        Mission(
            id = MissionType.LIBRARY_MISSION.missionId,
            text = MissionType.LIBRARY_MISSION.text,
            oxygenReward = 10,
            objective = 1,
            counter = 0,
        ),
        Mission(
            id = MissionType.MINI_GAME_MISSION.missionId,
            text = MissionType.MINI_GAME_MISSION.text,
            oxygenReward = 10,
            objective = 1,
            counter = 0,
        ),
    )

    val fakeMissions = listOf(
        Mission(
            id = 1,
            text = "Visitar a Mushy",
            oxygenReward = 10,
            objective = 1,
            counter = 0,
        ),
        Mission(
            id = 2,
            text = "Completar un nivel",
            oxygenReward = 20,
            objective = 1,
            counter = 0,
        ),
    )
}