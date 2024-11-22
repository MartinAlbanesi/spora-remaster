package com.gg.spora.core.di

import android.content.Context
import androidx.room.Room
import com.gg.spora.challenge.data.local.ChallengeDao
import com.gg.spora.core.data.SporaDatabase
import com.gg.spora.library.data.local.InfoCardDAO
import com.gg.spora.missions.data.local.MissionDao
import com.gg.spora.stage.data.local.StageDao
import com.gg.spora.tutorials.data.local.entity.TutorialCompletedDao
import com.gg.spora.user.data.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): SporaDatabase {
        return Room.databaseBuilder(
            appContext,
            SporaDatabase::class.java,
            "spora_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideUserDao(sporaDatabase: SporaDatabase): UserDao {
        return sporaDatabase.userDao()
    }

    @Singleton
    @Provides
    fun provideChallengeDao(sporaDatabase: SporaDatabase): ChallengeDao {
        return sporaDatabase.challengeDao()
    }

    @Singleton
    @Provides
    fun provideStageDao(sporaDatabase: SporaDatabase): StageDao {
        return sporaDatabase.stageDao()
    }

    @Provides
    fun provideInfoCardDao(database: SporaDatabase): InfoCardDAO {
        return database.infoCardDao()
    }

    @Singleton
    @Provides
    fun provideTutorialCompletedDao(database: SporaDatabase): TutorialCompletedDao {
        return database.tutorialCompletedDao()
    }

    @Singleton
    @Provides
    fun provideMissionDao(database: SporaDatabase): MissionDao {
        return database.missionDao()
    }
}