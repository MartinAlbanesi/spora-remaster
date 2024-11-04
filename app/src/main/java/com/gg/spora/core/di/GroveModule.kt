package com.gg.spora.core.di

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import com.gg.spora.core.data.database.GroveDatabase
import com.gg.spora.grove.data.GroveRepository
import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.data.database.dao.GroveDao
import com.gg.spora.grove.domain.GetForestTreeByIdUseCase
import com.gg.spora.grove.domain.GetSeedTreeByIdUseCase
import com.gg.spora.grove.domain.InsertForestTreeUseCase
import com.gg.spora.grove.domain.LoadForestTreesUseCase
import com.gg.spora.grove.domain.LoadSeedTreesUseCase
import com.gg.spora.grove.domain.SaveForestTreesUseCase
import com.gg.spora.grove.domain.SaveSeedTreesUseCase
import com.gg.spora.grove.domain.UpdateForestTreeGrowthStageByIdUseCase
import com.gg.spora.grove.ui.GroveViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GroveModule {

    @Provides
    @Singleton
    fun provideGroveDatabase(@ApplicationContext appContext: Context): GroveDatabase {
        return Room.databaseBuilder(
            appContext,
            GroveDatabase::class.java,
            "grove_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun groveDaoProvide(groveDatabase: GroveDatabase): GroveDao {
        return groveDatabase.groveDao()
    }

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
    fun provideSaveForestTreesUseCase(groveRepository: IGroveRepository): SaveForestTreesUseCase {
        return SaveForestTreesUseCase(groveRepository)
    }

    @Provides
    @Singleton
    fun provideGetForestTreeByIdUseCase(groveRepository: IGroveRepository): GetForestTreeByIdUseCase {
        return GetForestTreeByIdUseCase(groveRepository)
    }

    @Provides
    @Singleton
    fun provideInsertForestTreeUseCase(groveRepository: IGroveRepository): InsertForestTreeUseCase {
        return InsertForestTreeUseCase(groveRepository)
    }


    @Provides
    @Singleton
    fun provideGetSeedTreeByIdUseCase(groveRepository: IGroveRepository): GetSeedTreeByIdUseCase {
        return GetSeedTreeByIdUseCase(groveRepository)
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
        saveForestTreesUseCase: SaveForestTreesUseCase,
        getForestTreeByIdUseCase: GetForestTreeByIdUseCase,
        insertForestTreeUseCase: InsertForestTreeUseCase,
        getSeedTreeByIdUseCase: GetSeedTreeByIdUseCase,
        updateForestTreeGrowthStageByIdUseCase: UpdateForestTreeGrowthStageByIdUseCase,
    ): GroveViewModel {
        return GroveViewModel(
            loadSeedTreesUseCase,
            saveSeedTreesUseCase,
            loadForestTreesUseCase,
            saveForestTreesUseCase,
            getForestTreeByIdUseCase,
            insertForestTreeUseCase,
            getSeedTreeByIdUseCase,
            updateForestTreeGrowthStageByIdUseCase,
        )
    }
}