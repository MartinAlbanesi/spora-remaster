package com.gg.spora.challenge.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "object_detail_step",
    foreignKeys = [
        ForeignKey(
            entity = ObjectDetailEntity::class,
            parentColumns = ["id_object_detail"],
            childColumns = ["id_object_detail"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    primaryKeys = ["id_object_detail", "numberStep"]
)
data class StepObjectDetailEntity(
    @ColumnInfo(name = "id_object_detail") val idObjectDetail: Int,
    @ColumnInfo(name = "number_step") val numberStep: Int,
    @ColumnInfo(name = "name_object_detail") val nameObjectDetail: String?,
    @ColumnInfo(name = "description") val description: String?
)