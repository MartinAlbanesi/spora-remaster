package com.gg.spora.library.data

import android.content.Context
import androidx.room.Room
import com.gg.spora.library.data.database.InfoCardDatabase
import com.gg.spora.library.data.repository.InfoCardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LibraryModule {

    @Provides
    @Singleton
    fun provideInfoCardDatabase(@ApplicationContext context: Context): InfoCardDatabase {
        return Room.databaseBuilder(
            context,
            InfoCardDatabase::class.java,
            "info_card_database"
        ).build()
    }

    @Provides
    fun provideInfoCardDao(database: InfoCardDatabase): InfoCardDAO {
        return database.infoCardDao()
    }

    @Provides
    fun provideInfoCardRepository(infoCardDao: InfoCardDAO): InfoCardRepository {
        return InfoCardRepository(infoCardDao)
    }

}