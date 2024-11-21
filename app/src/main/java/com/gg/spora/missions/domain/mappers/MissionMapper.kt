package com.gg.spora.missions.domain.mappers

import com.gg.spora.missions.data.local.MissionEntity
import com.gg.spora.missions.domain.models.Mission

fun MissionEntity.toMission() = Mission(
    id = id,
    text = text,
    oxygenReward = oxygenReward,
    objective = objective,
    counter = counter,
)

fun Mission.toMissionEntity() = MissionEntity(
    id = id,
    text = text,
    oxygenReward = oxygenReward,
    objective = objective,
    counter = counter,
)