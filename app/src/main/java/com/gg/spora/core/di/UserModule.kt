package com.gg.spora.core.di

import com.gg.spora.core.firebase.FirestoreService
import com.gg.spora.user.data.network.UserRepositoryNetwork
import com.gg.spora.user.domain.GetCurrentUserUseCase
import com.gg.spora.user.domain.IUserRepositoryNetwork
import com.gg.spora.user.domain.SetNewUserUseCase
import com.google.firebase.auth.FirebaseAuth
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
    ) : IUserRepositoryNetwork {
        return UserRepositoryNetwork(firestoreService)
    }

    @Singleton
    @Provides
    fun provideGetCurrentUserUseCase(
        firebaseAuth: FirebaseAuth,
    ): GetCurrentUserUseCase {
        return GetCurrentUserUseCase(firebaseAuth)
    }

    @Singleton
    @Provides
    fun provideSetNewUserUseCase(userRepositoryNetwork: UserRepositoryNetwork) : SetNewUserUseCase{
        return SetNewUserUseCase(userRepositoryNetwork)
    }
}