package com.gg.spora.missions.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "missions")
data class MissionEntity(
    @PrimaryKey
    val id: Byte,
    val text: String,
    @ColumnInfo(name = "oxygen_reward") val oxygenReward: Byte,
    val objective: Byte,
    var counter: Byte,
    @ColumnInfo(name = "is_claimed") val isClaimed: Boolean
)
