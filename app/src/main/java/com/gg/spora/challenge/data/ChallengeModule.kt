package com.gg.spora.challenge.data

import android.content.Context
import androidx.room.Room
import com.gg.spora.challenge.data.dao.ChallengeDao
import com.gg.spora.challenge.data.repositories.ChallengeRepository
import com.gg.spora.core.data.SporaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ChallengeModule {

//    @Provides
//    @Singleton
//    fun provideChallengeDatabase(@ApplicationContext context: Context): SporaDatabase {
//        return Room.databaseBuilder(
//            context,
//            SporaDatabase::class.java,
//            "spora_database"
//        ).build()
//    }
//
//    @Provides
//    fun provideChallengeDao(database: SporaDatabase): ChallengeDao {
//        return database.challengeDao()
//    }

    @Provides
    fun provideChallengeRepository(challengeDao: ChallengeDao): ChallengeRepository {
        return ChallengeRepository(challengeDao)
    }
}
