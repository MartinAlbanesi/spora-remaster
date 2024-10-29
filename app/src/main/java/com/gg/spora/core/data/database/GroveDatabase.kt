package com.gg.spora.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gg.spora.grove.data.database.dao.GroveDao
import com.gg.spora.grove.data.database.entities.ForestTreeEntity
import com.gg.spora.grove.data.database.entities.SeedTreeEntity
import com.gg.spora.grove.domain.mappers.DurationConverter
import com.gg.spora.grove.domain.mappers.GrowthStageConverter
import com.gg.spora.grove.domain.mappers.LocalDateTimeConverter
import com.gg.spora.grove.domain.mappers.TreeTypeConverter

@Database(
    entities = [ForestTreeEntity::class, SeedTreeEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    TreeTypeConverter::class,
    LocalDateTimeConverter::class,
    DurationConverter::class,
    GrowthStageConverter::class
)
abstract class GroveDatabase : RoomDatabase() {
    abstract fun groveDao(): GroveDao
}