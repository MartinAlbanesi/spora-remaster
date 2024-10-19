package com.gg.spora.challenge.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gg.spora.challenge.domain.model.StepObjectDetail

@Entity(tableName = "object_detail")
data class ObjectDetailEntity(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "id_object_detail") val idObjectDetail: Int,
    @ColumnInfo(name = "name_object_detail") val nameObjectDetail: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "is_validate") val isValidate : Boolean
)