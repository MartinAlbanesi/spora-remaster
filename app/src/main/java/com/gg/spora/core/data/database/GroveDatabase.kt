package com.gg.spora.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gg.spora.grove.data.database.dao.GroveDao
import com.gg.spora.grove.data.database.entities.ForestTreeEntity
import com.gg.spora.grove.data.database.entities.SeedTreeEntity

@Database(
    entities = [ForestTreeEntity::class, SeedTreeEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GroveDatabase : RoomDatabase() {
    abstract fun groveDao(): GroveDao
}