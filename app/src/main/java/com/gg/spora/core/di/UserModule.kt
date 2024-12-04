package com.gg.spora.core.di

import android.content.Context
import com.gg.spora.core.firebase.FirestoreService
import com.gg.spora.tutorials.data.local.entity.TutorialCompletedDao
import com.gg.spora.user.data.local.UserDao
import com.gg.spora.user.data.local.UserRepositoryLocal
import com.gg.spora.user.data.network.UserRepositoryNetwork
import com.gg.spora.user.domain.GetUserAuthUseCase
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import com.gg.spora.user.domain.SetNewUserUseCase
import com.gg.spora.user.domain.SyncUserNetworkDataUseCase
import com.gg.spora.user.domain.UpdateUserImageUseCase
import com.gg.spora.user.domain.UpdateUserNameUseCase
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
        userDao: UserDao,
        tutorialCompletedDao: TutorialCompletedDao
    ) : IUserRepositoryLocal {
        return UserRepositoryLocal(userDao,tutorialCompletedDao)
    }

    @Singleton
    @Provides
    fun provideGetCurrentUserUseCase(
        firebaseAuth: FirebaseAuth,
    ): GetUserAuthUseCase {
        return GetUserAuthUseCase(firebaseAuth)
    }

    @Singleton
    @Provides
    fun provideSetNewUserUseCase(
        userRepositoryNetwork: UserRepositoryNetwork,
        userRepositoryLocal: UserRepositoryLocal
    ) : SetNewUserUseCase{
        return SetNewUserUseCase(userRepositoryNetwork, userRepositoryLocal)
    }

    @Singleton
    @Provides
    fun provideUpdateUserImageUseCase(
        userRepositoryLocal: UserRepositoryLocal
    ) : UpdateUserImageUseCase {
        return UpdateUserImageUseCase(userRepositoryLocal)
    }

    @Singleton
    @Provides
    fun provideUpdateUserNameUseCase(
        userRepositoryLocal: UserRepositoryLocal
    ) : UpdateUserNameUseCase {
        return UpdateUserNameUseCase(userRepositoryLocal)
    }

    @Singleton
    @Provides
    fun provideSyncUserNetworkData(
        userRepositoryLocal: IUserRepositoryLocal,
        userRepositoryNetwork: IUserRepositoryNetwork,
        @ApplicationContext context: Context
    ): SyncUserNetworkDataUseCase {
        return SyncUserNetworkDataUseCase(
            userRepositoryLocal,
            userRepositoryNetwork,
            context
        )
    }
}