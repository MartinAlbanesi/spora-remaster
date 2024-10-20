package com.gg.spora.core.di

import android.annotation.SuppressLint
import com.gg.spora.grove.data.GroveRepository
import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.domain.models.CollectOxygenUseCase
import com.gg.spora.grove.domain.models.GetForestTreesUseCase
import com.gg.spora.grove.domain.models.GetSeedTreesUseCase
import com.gg.spora.grove.domain.models.PlantSeedUseCase
import com.gg.spora.grove.ui.GroveViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GroveModule {

    @SuppressLint("NewApi")
    @Provides
    @Singleton
    fun provideGroveRepository(): IGroveRepository {
        return GroveRepository()
    }

    @Provides
    @Singleton
    fun provideGetSeedTreesUseCase(groveRepository: IGroveRepository): GetSeedTreesUseCase {
        return GetSeedTreesUseCase(groveRepository)
    }

    @Provides
    @Singleton
    fun provideGetForestTreesUseCase(groveRepository: IGroveRepository): GetForestTreesUseCase {
        return GetForestTreesUseCase(groveRepository)
    }

    @Provides
    @Singleton
    fun providePlantSeedUseCase(groveRepository: IGroveRepository): PlantSeedUseCase {
        return PlantSeedUseCase(groveRepository)
    }

    @Provides
    @Singleton
    fun provideCollectOxygenUseCase(groveRepository: IGroveRepository): CollectOxygenUseCase {
        return CollectOxygenUseCase(groveRepository)
    }

    @Provides
    @Singleton
    fun provideGroveViewModel(getSeedTreesUseCase: GetSeedTreesUseCase, getForestTreesUseCase: GetForestTreesUseCase, plantSeedUseCase: PlantSeedUseCase,/* collectOxygenUseCase: CollectOxygenUseCase*/): GroveViewModel {
        return GroveViewModel(getSeedTreesUseCase, getForestTreesUseCase, plantSeedUseCase, /*collectOxygenUseCase*/)
    }

}