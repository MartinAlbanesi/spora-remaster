package com.gg.spora.core.di

import android.content.Context
import androidx.room.Room
import com.gg.spora.challenge.data.dao.ChallengeDao
import com.gg.spora.core.data.SporaDatabase
import com.gg.spora.forestStage.data.local.StageDao
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
        ).build()
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
}