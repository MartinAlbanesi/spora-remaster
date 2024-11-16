package com.gg.spora.tutorials.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tutorial_completed")
data class TutorialCompletedEntity(
    @ColumnInfo(name = "tutorial_id")
    @PrimaryKey
    val tutorialId: Int,
    @ColumnInfo(name = "is_completed") val isCompleted: Boolean,
    @ColumnInfo(name = "user_id") val userId: String
)