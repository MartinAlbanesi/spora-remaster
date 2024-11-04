package com.gg.spora.library.data

import com.gg.spora.core.data.SporaDatabase
import com.gg.spora.library.data.local.InfoCardDAO
import com.gg.spora.library.data.repository.IInfoCardRepositoryLocal
import com.gg.spora.library.data.repository.InfoCardRepositoryLocal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LibraryModule {

    /*@Provides
    @Singleton
    fun provideInfoCardDatabase(@ApplicationContext context: Context): InfoCardDatabase {
        return Room.databaseBuilder(
            context,
            InfoCardDatabase::class.java,
            "info_card_database"
        ).build()
    }*/

    @Provides
    fun provideInfoCardRepositoryLocal(
        infoCardDao: InfoCardDAO
    ): IInfoCardRepositoryLocal {
        return InfoCardRepositoryLocal(infoCardDao)
    }

}