package com.gg.spora.grove.domain.mappers

import androidx.room.TypeConverter
import com.gg.spora.grove.domain.models.TreeType

object TreeTypeConverter {
    @TypeConverter
    fun toTreeType(value: String): TreeType {
        return when (value) {
            "MANGROVE" -> TreeType.MANGROVE
            "BAOBAB" -> TreeType.BAOBAB
            "SECUOYA" -> TreeType.SECUOYA
            "PINE" -> TreeType.PINE
            else -> TreeType.SECUOYA // Default value if not found
        }
    }

    @TypeConverter
    fun fromTreeType(treeType: TreeType): String {
        return treeType.name
    }
}