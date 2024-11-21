package com.gg.spora.library.data

import com.gg.spora.core.data.INetworkConnectivityChecker
import com.gg.spora.core.firebase.FirestoreService
import com.gg.spora.library.data.local.InfoCardDAO
import com.gg.spora.library.data.network.IInfoCardRepositoryNetwork
import com.gg.spora.library.data.network.InfoCardRepositoryNetwork
import com.gg.spora.library.data.repository.IInfoCardRepositoryLocal
import com.gg.spora.library.data.repository.InfoCardRepositoryLocal
import com.gg.spora.library.domain.usecases.GetAllInfoCardsUseCase
import com.gg.spora.library.domain.usecases.GetInfoCardListByCategoryUseCase
import com.gg.spora.library.domain.usecases.InsertNewInfoCardUseCase
import com.gg.spora.library.domain.usecases.UpdateInfoCardUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LibraryModule {

    @Provides
    @Singleton
    fun provideInfoCardRepositoryNetwork(
        firebaseFirestore: FirestoreService
    ): IInfoCardRepositoryNetwork {
        return InfoCardRepositoryNetwork(firebaseFirestore)
    }


    @Provides
    @Singleton
    fun provideInfoCardRepositoryLocal(
        infoCardDao: InfoCardDAO
    ): IInfoCardRepositoryLocal {
        return InfoCardRepositoryLocal(infoCardDao)
    }

    @Provides
    @Singleton
    fun provideGetAllInfoCardsUseCase(
        infoCardRepositoryLocal: IInfoCardRepositoryLocal,
        infoCardRepositoryNetwork: IInfoCardRepositoryNetwork,
        networkInfo : INetworkConnectivityChecker
    ): GetAllInfoCardsUseCase {
        return GetAllInfoCardsUseCase(infoCardRepositoryLocal, infoCardRepositoryNetwork, networkInfo)
    }


    @Provides
    @Singleton
    fun providesUpdateInfoCardUseCase(
        infoCardRepositoryNetwork: IInfoCardRepositoryNetwork,
        infoCardRepositoryLocal: IInfoCardRepositoryLocal,
        networkInfo : INetworkConnectivityChecker
    ): UpdateInfoCardUseCase {
        return UpdateInfoCardUseCase(infoCardRepositoryNetwork, infoCardRepositoryLocal,networkInfo)
    }


    @Provides
    @Singleton
    fun provideInsertNewInfoCardUseCase(
        infoCardRepositoryNetwork: IInfoCardRepositoryNetwork,
        infoCardRepositoryLocal: IInfoCardRepositoryLocal,
        networkInfo : INetworkConnectivityChecker
    ): InsertNewInfoCardUseCase {
        return InsertNewInfoCardUseCase(infoCardRepositoryNetwork, infoCardRepositoryLocal, networkInfo)
    }

    @Provides
    @Singleton
    fun provideGetInfoCardListByCategoryUseCase(
        infoCardRepositoryLocal: IInfoCardRepositoryLocal,
    ): GetInfoCardListByCategoryUseCase {
        return GetInfoCardListByCategoryUseCase(infoCardRepositoryLocal)
    }
}