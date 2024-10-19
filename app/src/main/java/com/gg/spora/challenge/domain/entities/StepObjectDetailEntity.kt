package com.gg.spora.challenge.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StepObjectDetailEntity(
    @PrimaryKey val idObjectDetail: Int,
    @ColumnInfo(name = "numberStep") val numberStep: Int,
    @ColumnInfo(name = "nameObjectDetail") val nameObjectDetail: String?,
    @ColumnInfo(name = "description") val description: String?
)