package com.gg.spora.user.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gg.spora.user.domain.models.LevelCompleted

@Entity(tableName = "user_entity")
data class UserEntity(
    @PrimaryKey val id: String,
    val userName: String,
    val email: String,
    val oxygen: Int,
    val treesCount: Int,
    val userImage: String,
    val weeklyOxygen: Int
//    val levelsCompleted : List<LevelCompleted>
)
