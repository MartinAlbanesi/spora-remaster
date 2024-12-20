package com.gg.spora.core.di

import com.gg.spora.core.data.INetworkConnectivityChecker
import com.gg.spora.core.data.NetworkConnectivityChecker
import com.gg.spora.core.firebase.FirestoreService
import android.content.Context
import com.gg.spora.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {

    @Singleton
    @Provides
    fun provideFirestore(): FirebaseFirestore {
        return Firebase.firestore
    }

    @Provides
    @Singleton
    fun provideFirestoreService(firestore: FirebaseFirestore): FirestoreService {
        return FirestoreService(firestore)
    }

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideNetworkConnectivityChecker(@ApplicationContext appContext: Context): INetworkConnectivityChecker {
        return NetworkConnectivityChecker(appContext)
    }
    
    @Singleton
    @Provides
    fun provideRemoteConfig(): FirebaseRemoteConfig {
        val wea = Firebase.remoteConfig.apply {
            setConfigSettingsAsync(
                remoteConfigSettings {
                    minimumFetchIntervalInSeconds = 3600
                }
            )
//            setDefaultsAsync(R.xml.remote_config_defaults)
            fetchAndActivate()
        }
        return wea
    }

//    @Singleton
//    @Provides
//    fun provideFirebaseStorage(): FirebaseStorage {
//        return Firebase.storage
//    }
}