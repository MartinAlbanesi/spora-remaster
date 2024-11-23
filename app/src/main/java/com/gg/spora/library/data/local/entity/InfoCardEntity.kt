package com.gg.spora.library.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gg.spora.core.utils.enums.StageType

/**
 * Data class for InfoCards used in LibraryScreen.kt
 *
 * @param id Primary key of the InfoCard
 * @param title Title of the InfoCard
 * @param info Info/description text of the InfoCard
 * @param image Image of the InfoCard
 * @param isUnlocked Boolean value indicating if the InfoCard is unlocked
 * @param category Category of the InfoCard, example: Forest, River, Desert
 */


@Entity(tableName = "info_cards")
data class InfoCardEntity(
    @PrimaryKey var id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "info") val info: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "isUnlocked") var isUnlocked: Boolean = false,
    @ColumnInfo(name = "category") val category: StageType
)