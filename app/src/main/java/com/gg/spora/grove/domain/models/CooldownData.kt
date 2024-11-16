package com.gg.spora.grove.domain.models

import com.gg.spora.grove.data.database.entities.CooldownDataEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

data class CooldownData(
    val treeId: String,
    val lastUpdateDate: LocalDateTime = LocalDateTime.now()
)

fun CooldownData.toCooldownDataEntity(): CooldownDataEntity {
    return CooldownDataEntity(
        treeId = treeId,
        lastUpdateDate = lastUpdateDate.toEpochSecond(ZoneOffset.UTC)
    )
}