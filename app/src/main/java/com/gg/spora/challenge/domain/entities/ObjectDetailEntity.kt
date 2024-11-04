package com.gg.spora.challenge.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gg.spora.challenge.domain.model.ObjectDetail

@Entity(tableName = "object_detail")
data class ObjectDetailEntity(
    @PrimaryKey
    @ColumnInfo(name = "name_object_detail") val nameObjectDetail: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "is_validate") val isValidate : Boolean
)

fun ObjectDetailEntity.toObjectDetail() = ObjectDetail(nameObjectDetail, description, isValidate)