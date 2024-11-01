package com.gg.spora.core.di

import com.gg.spora.core.firebase.FirestoreService
import com.gg.spora.user.data.local.UserDao
import com.gg.spora.user.data.local.UserRepositoryLocal
import com.gg.spora.user.data.network.UserRepositoryNetwork
import com.gg.spora.user.domain.GetCurrentUserUseCase
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import com.gg.spora.user.domain.SetNewUserUseCase
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
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

    @Provides
    @Singleton
    fun provideUserRepositoryLocal(
        userDao: UserDao
    ) : IUserRepositoryLocal {
        return UserRepositoryLocal(userDao)
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
    fun provideSetNewUserUseCase(
        userRepositoryNetwork: UserRepositoryNetwork,
        userRepositoryLocal: UserRepositoryLocal
    ) : SetNewUserUseCase{
        return SetNewUserUseCase(userRepositoryNetwork, userRepositoryLocal)
    }
}