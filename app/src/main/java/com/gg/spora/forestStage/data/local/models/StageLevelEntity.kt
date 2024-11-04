package com.gg.spora.forestStage.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stage_level")
data class StageLevelEntity(
    @PrimaryKey val id: String,
    val stageType: String,
    val levelPreviewImage: Int,
    val stageBackgroundImage: Int,
)
