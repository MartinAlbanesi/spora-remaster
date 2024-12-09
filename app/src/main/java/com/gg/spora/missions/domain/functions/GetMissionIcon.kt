package com.gg.spora.missions.domain.functions

import com.gg.spora.R
import com.gg.spora.missions.domain.enums.MissionType

fun getMissionIcon(missionId: Byte): Int {
    return when (missionId) {
        MissionType.LIBRARY_MISSION.missionId -> R.drawable.mushy_idle
        MissionType.MINI_GAME_MISSION.missionId -> R.drawable.challenge_level
        MissionType.GROVE_MISSION.missionId -> R.drawable.trees_icon
        MissionType.SCAN_MISSION.missionId -> R.drawable.camera_icon
        MissionType.AD_MISSION.missionId -> R.drawable.ad_icon
        else -> R.drawable.tutorial_seed
    }
}