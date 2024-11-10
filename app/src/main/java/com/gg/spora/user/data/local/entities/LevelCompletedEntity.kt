package com.gg.spora.user.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "level_completed_entity")
data class LevelCompletedEntity(
    @PrimaryKey val levelId: String,
    val stageType: String,
    val starState: String,
    val userId: String
)
