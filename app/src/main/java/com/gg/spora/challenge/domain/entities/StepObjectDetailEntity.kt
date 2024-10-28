package com.gg.spora.challenge.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "object_detail_step",
    foreignKeys = [
        ForeignKey(
            entity = ObjectDetailEntity::class,
            parentColumns = ["name_object_detail"],
            childColumns = ["name_object_detail"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    primaryKeys = ["name_object_detail", "number_step"]
)
data class StepObjectDetailEntity(
    @ColumnInfo(name = "name_object_detail") val nameObjectDetail: String,
    @ColumnInfo(name = "number_step") val numberStep: Int,
    @ColumnInfo(name = "description") val description: String?
)