package com.gg.spora.forestStage.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gg.spora.core.utils.enums.StageType

@Entity(tableName = "stage_level")
data class StageEntity(
    @PrimaryKey val id: String,
    val stageType: String,
    val levelPreviewImage: Int,
    val stageBackgroundImage: Int,
)
