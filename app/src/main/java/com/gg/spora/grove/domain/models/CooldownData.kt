package com.gg.spora.grove.domain.models

import com.gg.spora.grove.data.database.entities.CooldownDataEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * Data class representing cooldown data for a tree.
 * @param treeId The ID of the tree.
 * @param lastUpdateDate The last update date of the cooldown data.
 */
data class CooldownData(
    val treeId: String,
    val lastUpdateDate: LocalDateTime? //= LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)
)

// Extension function mapper to convert CooldownData to CooldownDataEntity
fun CooldownData.toCooldownDataEntity(): CooldownDataEntity {
    return CooldownDataEntity(
        treeId = treeId,
        lastUpdateDate = lastUpdateDate!!.toEpochSecond(ZoneOffset.UTC)
    )
}