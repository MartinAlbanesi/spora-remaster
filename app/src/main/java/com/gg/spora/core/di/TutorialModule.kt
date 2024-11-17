package com.gg.spora.core.di

import com.gg.spora.tutorials.data.local.TutorialRepositoryLocal
import com.gg.spora.tutorials.data.local.entity.TutorialCompletedDao
import com.gg.spora.tutorials.domain.repository.ITutorialRepositoryLocal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TutorialModule {

    @Singleton
    @Provides
    fun provideTutorialRepositoryLocal(tutorialCompletedDao: TutorialCompletedDao): ITutorialRepositoryLocal {
        return TutorialRepositoryLocal(tutorialCompletedDao)
    }
}