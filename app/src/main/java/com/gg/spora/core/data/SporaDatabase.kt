package com.gg.spora.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gg.spora.challenge.data.dao.ChallengeDao
import com.gg.spora.challenge.domain.entities.ObjectDetailEntity
import com.gg.spora.challenge.domain.entities.StepObjectDetailEntity
import com.gg.spora.user.data.local.UserDao
import com.gg.spora.user.data.local.entities.LevelCompletedEntity
import com.gg.spora.user.data.local.entities.UserEntity

@Database(
    entities = [
        ObjectDetailEntity::class,
        StepObjectDetailEntity::class,
        UserEntity::class,
        LevelCompletedEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class SporaDatabase : RoomDatabase() {
    abstract fun challengeDao(): ChallengeDao

    abstract fun userDao(): UserDao
}