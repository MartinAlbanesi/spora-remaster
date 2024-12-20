package com.gg.spora.core.firebase

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RemoteConfigService @Inject constructor(
    private val remoteConfig: FirebaseRemoteConfig
) {
    companion object {
        const val MIN_VERSION = "min_version"
    }

    suspend fun getMinVersion(): List<Byte> {
        remoteConfig.fetch(0)
        remoteConfig.activate().await()
        val minVersion = remoteConfig.getString("min_version")

        if(minVersion.isBlank()) return listOf(0,0,0)

        return minVersion.split(".").map { it.toByte() }
    }
}