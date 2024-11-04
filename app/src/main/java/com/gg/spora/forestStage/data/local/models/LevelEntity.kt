package com.gg.spora.forestStage.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gg.spora.core.utils.enums.TypeQuestion

@Entity(tableName = "level_entity")
data class LevelEntity(
    @PrimaryKey val id: String,
    val levelName : String,
    val levelNumber: Byte,
    val stageType: String,
    val requiredOxygen: Short,
    val rewardsOxygen: String,
    val starState: String,
    val typeQuestion: String,
    val quizCount: Byte,
    val imageCount: Byte,
    val relationsCount: Byte
)
