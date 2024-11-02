package com.gg.spora.core.di

import com.gg.spora.core.firebase.FirestoreService
import com.gg.spora.forestStage.domain.IStageRepositoryNetwork
import com.gg.spora.forestStage.data.FakeStageLocalRepositoryLocal
import com.gg.spora.forestStage.data.network.models.StageRepositoryNetwork
import com.gg.spora.forestStage.domain.GetLevelsUseCase
import com.gg.spora.forestStage.domain.IStageRepositoryLocal
import com.gg.spora.user.domain.GetUserNetworkUseCase
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
    fun provideStageRepository() : IStageRepositoryLocal {
        return FakeStageLocalRepositoryLocal()
    }

//    @Singleton
//    @Provides
//    fun provideUpdateLevelStateUseCase(stageRepository: IStageRepositoryLocal) : UpdateLevelStateUseCase{
//        return UpdateLevelStateUseCase(stageRepository)
//    }

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
        getUserNetworkUseCase: GetUserNetworkUseCase
    ): GetLevelsUseCase {
        return GetLevelsUseCase(stageRepositoryNetwork,getUserNetworkUseCase)
    }

}