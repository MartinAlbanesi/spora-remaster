package com.gg.spora.core.di

import com.gg.spora.core.firebase.FirestoreService
import com.gg.spora.user.data.network.models.UserRepositoryNetwork
import com.gg.spora.user.domain.IUserNetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserModule {

    @Provides
    @Singleton
    fun provideUserRepositoryNetwork(
        firestoreService: FirestoreService
    ) : IUserNetworkRepository {
        return UserRepositoryNetwork(firestoreService)
    }
}