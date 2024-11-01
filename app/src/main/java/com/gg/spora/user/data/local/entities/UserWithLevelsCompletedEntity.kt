package com.gg.spora.user.data.local.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity(tableName = "user_with_levels_completed")
data class UserWithLevelsCompletedEntity(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val levelsCompleted: List<LevelCompletedEntity>
)
