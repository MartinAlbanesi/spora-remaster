package com.gg.spora.core.di

import com.gg.spora.challenge.data.local.ChallengeDao
import com.gg.spora.challenge.data.local.ChallengeRepositoryLocal
import com.gg.spora.challenge.data.network.ChallengeRepositoryNetwork
import com.gg.spora.challenge.domain.interfaces.IChallengeRepositoryLocal
import com.gg.spora.challenge.domain.interfaces.IChallengeRepositoryNetwork
import com.gg.spora.core.firebase.FirestoreService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ChallengeModule {

    @Provides
    @Singleton
    fun provideChallengeRepository(challengeDao: ChallengeDao): IChallengeRepositoryLocal {
        return ChallengeRepositoryLocal(challengeDao)
    }

    @Provides
    @Singleton
    fun provideChallengeRepositoryNetwork(firestoreService: FirestoreService): IChallengeRepositoryNetwork {
        return ChallengeRepositoryNetwork(firestoreService)
    }
}
