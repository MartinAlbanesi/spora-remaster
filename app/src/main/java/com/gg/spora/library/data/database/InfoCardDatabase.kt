package com.gg.spora.library.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gg.spora.library.data.InfoCardDAO
import com.gg.spora.library.domain.InfoCard

@Database(entities = [InfoCard::class], version = 1)
abstract class InfoCardDatabase: RoomDatabase() {
    abstract fun infoCardDao(): InfoCardDAO

}