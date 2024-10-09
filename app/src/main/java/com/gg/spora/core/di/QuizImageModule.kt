package com.gg.spora.core.di

import com.gg.spora.minigameQuizImage.data.local.FakeQuizImageLocalRepository
import com.gg.spora.minigameQuizImage.domain.model.GetRamdonQuestionImage
import com.gg.spora.minigameQuizImage.domain.model.IQuizImageLocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent ::class)
class QuizImageModule {

    @Provides
    @Singleton
    fun provideQuizImageLocalRepository(): IQuizImageLocalRepository {
        return FakeQuizImageLocalRepository()
    }

    @Singleton
    @Provides
    fun provideGetRandomQuestionImage() =
        GetRamdonQuestionImage(provideQuizImageLocalRepository())

}
