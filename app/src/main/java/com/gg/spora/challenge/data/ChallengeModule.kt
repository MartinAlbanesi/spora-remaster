package com.gg.spora.challenge.data

import com.gg.spora.challenge.data.local.ChallengeDao
import com.gg.spora.challenge.data.repositories.ChallengeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

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
