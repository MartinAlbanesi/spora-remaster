package com.gg.spora.core.di

import com.gg.spora.core.firebase.FirestoreService
import com.gg.spora.forestStage.IStageRepositoryNetwork
import com.gg.spora.forestStage.data.FakeStageLocalRepository
import com.gg.spora.forestStage.data.network.models.StageRepositoryNetwork
import com.gg.spora.forestStage.domain.GetLevelsUseCase
import com.gg.spora.forestStage.domain.IStageRepository
import com.gg.spora.forestStage.domain.UpdateLevelStateUseCase
import com.gg.spora.user.domain.GetUserFromDBUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StageModule {

    @Provides
    @Singleton
    fun provideStageRepository() : IStageRepository {
        return FakeStageLocalRepository()
    }

    @Singleton
    @Provides
    fun provideUpdateLevelStateUseCase(stageRepository: IStageRepository) : UpdateLevelStateUseCase{
        return UpdateLevelStateUseCase(stageRepository)
    }

    @Singleton
    @Provides
    fun provideStageRepositoryNetwork(
        firestoreService: FirestoreService
    ) : IStageRepositoryNetwork {
        return StageRepositoryNetwork(firestoreService)
    }

    @Singleton
    @Provides
    fun provideGetLevelsUseCase(
        stageRepositoryNetwork: IStageRepositoryNetwork,
        getUserFromDBUseCase: GetUserFromDBUseCase
    ): GetLevelsUseCase {
        return GetLevelsUseCase(stageRepositoryNetwork,getUserFromDBUseCase)
    }

}