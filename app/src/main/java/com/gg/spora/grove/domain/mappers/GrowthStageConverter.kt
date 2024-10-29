package com.gg.spora.grove.domain.mappers

import androidx.room.TypeConverter
import com.gg.spora.grove.domain.models.GrowthStage

object GrowthStageConverter {
    @TypeConverter
    fun toGrowthStage(value: String): GrowthStage {
        return when (value) {
            "SPROUT" -> GrowthStage.SPROUT
            "MEDIUM" -> GrowthStage.MEDIUM
            "MATURE" -> GrowthStage.ADULT
            else -> GrowthStage.SPROUT // Default value if not found
        }
    }

    @TypeConverter
    fun fromGrowthStage(growthStage: GrowthStage): String {
        return growthStage.name
    }
}