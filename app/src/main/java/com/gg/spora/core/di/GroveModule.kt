package com.gg.spora.core.di

import android.annotation.SuppressLint
import com.gg.spora.grove.data.GroveRepository
import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.data.database.dao.GroveDao
import com.gg.spora.grove.domain.InsertForestTreeUseCase
import com.gg.spora.grove.domain.LoadForestTreesUseCase
import com.gg.spora.grove.domain.LoadSeedTreesUseCase
import com.gg.spora.grove.domain.SaveSeedTreesUseCase
import com.gg.spora.grove.domain.UpdateForestTreeGrowthStageByIdUseCase
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
    fun provideGroveRepository(groveDao: GroveDao): IGroveRepository {
        return GroveRepository(groveDao)
    }

    @Provides
    @Singleton
    fun provideLoadSeedTreesUseCase(groveRepository: IGroveRepository): LoadSeedTreesUseCase {
        return LoadSeedTreesUseCase(groveRepository)
    }

    @Provides
    @Singleton
    fun provideSaveSeedTreesUseCase(groveRepository: IGroveRepository): SaveSeedTreesUseCase {
        return SaveSeedTreesUseCase(groveRepository)
    }

    @Provides
    @Singleton
    fun provideLoadForestTreesUseCase(groveRepository: IGroveRepository): LoadForestTreesUseCase {
        return LoadForestTreesUseCase(groveRepository)
    }

    @Provides
    @Singleton
    fun provideInsertForestTreeUseCase(groveRepository: IGroveRepository): InsertForestTreeUseCase {
        return InsertForestTreeUseCase(groveRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateForestTreeGrowthStageByIdUseCase(groveRepository: IGroveRepository): UpdateForestTreeGrowthStageByIdUseCase {
        return UpdateForestTreeGrowthStageByIdUseCase(groveRepository)
    }

    @Provides
    @Singleton
    fun provideGroveViewModel(
        loadSeedTreesUseCase: LoadSeedTreesUseCase,
        saveSeedTreesUseCase: SaveSeedTreesUseCase,
        loadForestTreesUseCase: LoadForestTreesUseCase,
        insertForestTreeUseCase: InsertForestTreeUseCase,
        updateForestTreeGrowthStageByIdUseCase: UpdateForestTreeGrowthStageByIdUseCase,
    ): GroveViewModel {
        return GroveViewModel(
            loadSeedTreesUseCase,
            saveSeedTreesUseCase,
            loadForestTreesUseCase,
            insertForestTreeUseCase,
            updateForestTreeGrowthStageByIdUseCase,
        )
    }
}