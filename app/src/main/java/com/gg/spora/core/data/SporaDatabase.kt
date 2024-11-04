package com.gg.spora.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gg.spora.challenge.data.dao.ChallengeDao
import com.gg.spora.challenge.domain.entities.ObjectDetailEntity
import com.gg.spora.challenge.domain.entities.StepObjectDetailEntity

@Database(entities = [ObjectDetailEntity::class, StepObjectDetailEntity::class], version = 3, exportSchema = false)
abstract class SporaDatabase  : RoomDatabase() {
    abstract fun challengeDao() : ChallengeDao
}