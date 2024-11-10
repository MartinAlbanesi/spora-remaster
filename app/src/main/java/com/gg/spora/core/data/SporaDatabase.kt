package com.gg.spora.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gg.spora.challenge.data.local.ChallengeDao
import com.gg.spora.challenge.domain.entities.ObjectDetailEntity
import com.gg.spora.challenge.domain.entities.StepObjectDetailEntity
import com.gg.spora.library.data.local.InfoCardDAO
import com.gg.spora.library.data.local.entity.InfoCardEntity
import com.gg.spora.stage.data.local.StageDao
import com.gg.spora.stage.data.local.models.LevelEntity
import com.gg.spora.stage.data.local.models.StageLevelEntity
import com.gg.spora.user.data.local.UserDao
import com.gg.spora.user.data.local.entities.LevelCompletedEntity
import com.gg.spora.user.data.local.entities.UserEntity

@Database(
    entities = [
        ObjectDetailEntity::class,
        StepObjectDetailEntity::class,
        UserEntity::class,
        LevelCompletedEntity::class,
        InfoCardEntity::class,
        LevelEntity::class,
        StageLevelEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class SporaDatabase : RoomDatabase() {

    abstract fun challengeDao(): ChallengeDao

    abstract fun infoCardDao(): InfoCardDAO

    abstract fun userDao(): UserDao

    abstract fun stageDao(): StageDao
}