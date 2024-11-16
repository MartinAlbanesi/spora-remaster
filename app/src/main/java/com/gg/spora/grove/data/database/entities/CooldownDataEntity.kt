package com.gg.spora.grove.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gg.spora.grove.domain.models.CooldownData
import java.time.LocalDateTime
import java.time.ZoneOffset

@Entity(tableName = "cooldown_data")
data class CooldownDataEntity(
    @PrimaryKey(autoGenerate = false) val treeId: String, // Assuming treeId is a String
    @ColumnInfo(name = "last_update_date") val lastUpdateDate: Long
)

fun CooldownDataEntity.toCooldownData(): CooldownData {
    return CooldownData(
        treeId = treeId,
        lastUpdateDate = LocalDateTime.ofEpochSecond(lastUpdateDate, 0, ZoneOffset.UTC)
    )
}