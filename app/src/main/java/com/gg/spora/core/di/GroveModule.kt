package com.gg.spora.core.di

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import com.gg.spora.core.data.database.GroveDatabase
import com.gg.spora.grove.data.GroveRepository
import com.gg.spora.grove.data.IGroveRepository
import com.gg.spora.grove.data.database.dao.GroveDao
import com.gg.spora.grove.domain.CollectOxygenUseCase
import com.gg.spora.grove.domain.GetForestTreesUseCase
import com.gg.spora.grove.domain.GetSeedTreesUseCase
import com.gg.spora.grove.domain.PlantSeedUseCase
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
        ).build()
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
    fun provideGroveViewModel(
        getSeedTreesUseCase: GetSeedTreesUseCase,
        getForestTreesUseCase: GetForestTreesUseCase,
        plantSeedUseCase: PlantSeedUseCase/* collectOxygenUseCase: CollectOxygenUseCase*/
    ): GroveViewModel {
        return GroveViewModel(
            getSeedTreesUseCase,
            getForestTreesUseCase,
            plantSeedUseCase /*collectOxygenUseCase*/
        )
    }

}