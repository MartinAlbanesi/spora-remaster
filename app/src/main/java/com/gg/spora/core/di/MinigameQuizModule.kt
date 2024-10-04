package com.gg.spora.core.di

import com.gg.spora.quiz.domain.FakeQuizLocalRepository
import com.gg.spora.quiz.domain.GetRandomQuestionFromTypeUseCase
import com.gg.spora.quiz.domain.IQuizLocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MinigameQuizModule {

    @Provides
    @Singleton
    fun provideQuizLocalRepository(): IQuizLocalRepository {
        return FakeQuizLocalRepository()
    }

    @Singleton
    @Provides
    fun provideGetRandomQuestionFromTypeUseCase() =
        GetRandomQuestionFromTypeUseCase(provideQuizLocalRepository())
}