package com.gg.spora.core.di

import android.annotation.SuppressLint
import com.gg.spora.grove.data.database.dao.GroveDao
import com.gg.spora.grove.data.local.GroveRepository
import com.gg.spora.grove.domain.DeleteForestTreeByIdUseCase
import com.gg.spora.grove.domain.DeleteSeedTreeByIdUseCase
import com.gg.spora.grove.domain.GetCooldownDataByIdUseCase
import com.gg.spora.grove.domain.InsertCooldownDataUseCase
import com.gg.spora.grove.domain.InsertForestTreeUseCase
import com.gg.spora.grove.domain.InsertSeedTreeUseCase
import com.gg.spora.grove.domain.LoadForestTreesUseCase
import com.gg.spora.grove.domain.LoadSeedTreesUseCase
import com.gg.spora.grove.domain.SaveSeedTreesUseCase
import com.gg.spora.grove.domain.UpdateForestTreeGrowthStageByIdUseCase
import com.gg.spora.grove.domain.UpdateTimesOxygenClaimedUseCase
import com.gg.spora.grove.domain.interfaces.IGroveRepository
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
    /*
    @Provides
    @Singleton
    fun provideInsertForestTreeUseCase(groveRepository: IGroveRepository): InsertForestTreeUseCase {
        return InsertForestTreeUseCase(groveRepository, getUserAuthUseCase, )
    }
*/
    @Provides
    @Singleton
    fun provideUpdateForestTreeGrowthStageByIdUseCase(groveRepository: IGroveRepository): UpdateForestTreeGrowthStageByIdUseCase {
        return UpdateForestTreeGrowthStageByIdUseCase(groveRepository)
    }

    @Provides
    @Singleton
    fun provideGetCooldownDataByIdUseCase(groveRepository: IGroveRepository): GetCooldownDataByIdUseCase {
        return GetCooldownDataByIdUseCase(groveRepository)
    }

    @Provides
    @Singleton
    fun provideInsertCooldownDataUseCase(groveRepository: IGroveRepository): InsertCooldownDataUseCase {
        return InsertCooldownDataUseCase(groveRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteSeedTreeByIdUseCase(groveRepository: IGroveRepository): DeleteSeedTreeByIdUseCase {
        return DeleteSeedTreeByIdUseCase(groveRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteForestTreeByIdUseCase(groveRepository: IGroveRepository): DeleteForestTreeByIdUseCase {
        return DeleteForestTreeByIdUseCase(groveRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateTimesOxygenClaimedUseCase(groveRepository: IGroveRepository): UpdateTimesOxygenClaimedUseCase {
        return UpdateTimesOxygenClaimedUseCase(groveRepository)
    }
}