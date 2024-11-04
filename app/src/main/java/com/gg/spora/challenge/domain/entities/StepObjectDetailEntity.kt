package com.gg.spora.challenge.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.gg.spora.challenge.domain.model.StepObjectDetail

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
    @ColumnInfo(name = "title_step") val titleStep: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "is_first") val isFirst: Boolean,
    @ColumnInfo(name = "is_last") val isLast: Boolean
)

fun StepObjectDetailEntity.toStepObjectDetail() = StepObjectDetail(numberStep, nameObjectDetail, titleStep, description, isFirst, isLast)