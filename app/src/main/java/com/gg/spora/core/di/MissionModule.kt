package com.gg.spora.core.di

import com.gg.spora.missions.data.local.MissionDao
import com.gg.spora.missions.data.local.MissionRepositoryLocal
import com.gg.spora.missions.domain.repository.IMissionRepositoryLocal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MissionModule {

    @Provides
    @Singleton
    fun provideMissionRepositoryLocal(missionDao: MissionDao): IMissionRepositoryLocal {
        return MissionRepositoryLocal(missionDao)
    }
}