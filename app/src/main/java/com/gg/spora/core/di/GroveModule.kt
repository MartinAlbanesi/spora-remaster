package com.gg.spora.core.di

import android.annotation.SuppressLint
import com.gg.spora.grove.data.database.dao.GroveDao
import com.gg.spora.grove.data.local.ForestTreeRepositoryLocalImpl
import com.gg.spora.grove.data.local.SeedTreeRepositoryLocalImpl
import com.gg.spora.grove.domain.interfaces.IForestTreeRepositoryLocal
import com.gg.spora.grove.domain.interfaces.ISeedTreeRepositoryLocal
import com.gg.spora.grove.domain.useCases.forestTrees.DeleteForestTreeByIdUseCase
import com.gg.spora.grove.domain.useCases.forestTrees.InsertForestTreeUseCase
import com.gg.spora.grove.domain.useCases.forestTrees.LoadForestTreesExistsUseCase
import com.gg.spora.grove.domain.useCases.forestTrees.LoadForestTreesUseCase
import com.gg.spora.grove.domain.useCases.forestTrees.UpdateForestTreeGrowthStageByIdUseCase
import com.gg.spora.grove.domain.useCases.forestTrees.UpdateTimesOxygenClaimedUseCase
import com.gg.spora.grove.domain.useCases.seedTrees.DeleteSeedTreeByIdUseCase
import com.gg.spora.grove.domain.useCases.seedTrees.GetCooldownDataByIdUseCase
import com.gg.spora.grove.domain.useCases.seedTrees.InsertCooldownDataUseCase
import com.gg.spora.grove.domain.useCases.seedTrees.LoadSeedTreesUseCase
import com.gg.spora.grove.domain.useCases.seedTrees.SaveSeedTreesUseCase
import com.gg.spora.user.data.local.UserRepositoryLocal
import com.gg.spora.user.domain.GetUserAuthUseCase
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
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
    fun provideSeedTreeRepositoryLocal(groveDao: GroveDao): ISeedTreeRepositoryLocal {
        return SeedTreeRepositoryLocalImpl(groveDao)
    }

    @Provides
    @Singleton
    fun provideForestTreeRepositoryLocal(groveDao: GroveDao): IForestTreeRepositoryLocal {
        return ForestTreeRepositoryLocalImpl(groveDao)
    }

    @Provides
    @Singleton
    fun provideLoadSeedTreesUseCase(
                                    userRepositoryLocal: UserRepositoryLocal,  seedTreeRepositoryLocal: ISeedTreeRepositoryLocal): LoadSeedTreesUseCase {
        return LoadSeedTreesUseCase(userRepositoryLocal,seedTreeRepositoryLocal)
    }

    @Provides
    @Singleton
    fun provideSaveSeedTreesUseCase(seedTreeRepositoryLocal: ISeedTreeRepositoryLocal): SaveSeedTreesUseCase {
        return SaveSeedTreesUseCase(seedTreeRepositoryLocal)
    }

    @Provides
    @Singleton
    fun provideLoadForestTreesUseCase(forestTreeRepositoryLocal: IForestTreeRepositoryLocal,
                                      userRepositoryLocal: UserRepositoryLocal): LoadForestTreesUseCase {
        return LoadForestTreesUseCase(
            forestTreeRepositoryLocal,
            //userRepositoryLocal
        )
    }

    @Provides
    @Singleton
    fun provideInsertForestTreeUseCase(forestTreeRepositoryLocal: IForestTreeRepositoryLocal,
                                       userRepositoryLocal: IUserRepositoryLocal,
                                       userRepositoryNetwork: IUserRepositoryNetwork,
                                       getUserAuthUseCase: GetUserAuthUseCase,
                                       loadForestTreesExistsUseCase: LoadForestTreesExistsUseCase
    ): InsertForestTreeUseCase {
        return InsertForestTreeUseCase(forestTreeRepositoryLocal,
            userRepositoryLocal,
            userRepositoryNetwork,
            getUserAuthUseCase,
            loadForestTreesExistsUseCase)
    }

    @Provides
    @Singleton
    fun provideUpdateForestTreeGrowthStageByIdUseCase(forestTreeRepositoryLocal: IForestTreeRepositoryLocal): UpdateForestTreeGrowthStageByIdUseCase {
        return UpdateForestTreeGrowthStageByIdUseCase(forestTreeRepositoryLocal)
    }

    @Provides
    @Singleton
    fun provideGetCooldownDataByIdUseCase(seedTreeRepositoryLocal: ISeedTreeRepositoryLocal): GetCooldownDataByIdUseCase {
        return GetCooldownDataByIdUseCase(seedTreeRepositoryLocal)
    }

    @Provides
    @Singleton
    fun provideInsertCooldownDataUseCase(seedTreeRepositoryLocal: ISeedTreeRepositoryLocal): InsertCooldownDataUseCase {
        return InsertCooldownDataUseCase(seedTreeRepositoryLocal)
    }

    @Provides
    @Singleton
    fun provideDeleteSeedTreeByIdUseCase(seedTreeRepositoryLocal: ISeedTreeRepositoryLocal): DeleteSeedTreeByIdUseCase {
        return DeleteSeedTreeByIdUseCase(seedTreeRepositoryLocal)
    }

    @Provides
    @Singleton
    fun provideDeleteForestTreeByIdUseCase(forestTreeRepositoryLocal: IForestTreeRepositoryLocal): DeleteForestTreeByIdUseCase {
        return DeleteForestTreeByIdUseCase(forestTreeRepositoryLocal)
    }

    @Provides
    @Singleton
    fun provideUpdateTimesOxygenClaimedUseCase(forestTreeRepositoryLocal: IForestTreeRepositoryLocal): UpdateTimesOxygenClaimedUseCase {
        return UpdateTimesOxygenClaimedUseCase(forestTreeRepositoryLocal)
    }
}