package com.gg.spora.missions.data.local

import com.gg.spora.core.utils.SporaConstant.REWARDED_AD_REWARD
import com.gg.spora.missions.domain.enums.MissionType
import com.gg.spora.missions.domain.models.Mission

object MissionModels {

    val missions = listOf(
        Mission(
            id = MissionType.LIBRARY_MISSION.missionId,
            text = MissionType.LIBRARY_MISSION.text,
            oxygenReward = 10,
            objective = 1,
        ),
        Mission(
            id = MissionType.MINI_GAME_MISSION.missionId,
            text = MissionType.MINI_GAME_MISSION.text,
            oxygenReward = 20,
            objective = 1,
        ),
        Mission(
            id = MissionType.GROVE_MISSION.missionId,
            text = MissionType.GROVE_MISSION.text,
            oxygenReward = 30,
            objective = 1,
        ),
        Mission(
            id = MissionType.SCAN_MISSION.missionId,
            text = MissionType.SCAN_MISSION.text,
            oxygenReward = 30,
            objective = 1,
        )
    )

    val missionAd = Mission(
        id = MissionType.AD_MISSION.missionId,
        text = MissionType.AD_MISSION.text,
        oxygenReward = REWARDED_AD_REWARD,
        objective = 1,
        isCompleted = true,
        counter = 1
    )

    val fakeMissions = listOf(
        Mission(
            id = MissionType.LIBRARY_MISSION.missionId,
            text = MissionType.LIBRARY_MISSION.text,
            oxygenReward = 10,
            objective = 1,
            counter = 0,
            isCompleted = true,
            isClaimed = true
        ),
        Mission(
            id = MissionType.MINI_GAME_MISSION.missionId,
            text = MissionType.MINI_GAME_MISSION.text,
            oxygenReward = 10,
            objective = 1,
            counter = 0,
            isCompleted = true
        ),
        Mission(
            id = 2,
            text = "Tutorial",
            oxygenReward = 10,
            objective = 1,
            counter = 0,
        )
    )
}