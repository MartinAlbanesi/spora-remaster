package com.gg.spora.core.di

import com.gg.spora.forestStage.data.FakeStageLocalRepository
import com.gg.spora.forestStage.domain.IStageRepository
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
}