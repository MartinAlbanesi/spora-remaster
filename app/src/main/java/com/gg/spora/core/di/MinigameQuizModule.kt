package com.gg.spora.core.di


import android.content.Context
import com.gg.spora.miniGames.data.local.FakeQuizLocalRepository
import com.gg.spora.miniGames.data.local.QuizLocalRepository
import com.gg.spora.miniGames.data.local.QuizLocalService
import com.gg.spora.miniGames.domain.GetRandomQuestionFromTypeUseCase
import com.gg.spora.miniGames.domain.IQuizLocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MinigameQuizModule {

    @Singleton
    @Provides
    fun provideQuizLocalService(): QuizLocalService {
        return QuizLocalService()
    }

    @Provides
    @Singleton
    fun provideQuizLocalRepository(
//        @ApplicationContext context: Context,
//        quizLocalService: QuizLocalService
    ): IQuizLocalRepository {
        return FakeQuizLocalRepository()
    }

    @Singleton
    @Provides
    fun provideGetRandomQuestionFromTypeUseCase(
        quizLocalRepository: IQuizLocalRepository): GetRandomQuestionFromTypeUseCase {
        return GetRandomQuestionFromTypeUseCase(quizLocalRepository)
    }
}