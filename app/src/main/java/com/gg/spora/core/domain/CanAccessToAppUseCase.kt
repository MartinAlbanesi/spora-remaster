package com.gg.spora.core.domain

import com.gg.spora.core.firebase.RemoteConfigService
import javax.inject.Inject

class CanAccessToAppUseCase @Inject constructor(
    private val getCurrentVersionUseCase: GetCurrentVersionUseCase,
    private val remoteConfigService: RemoteConfigService
) {
    suspend operator fun invoke(): Boolean {
        val currentVersion = getCurrentVersionUseCase()
        val minVersion = remoteConfigService.getMinVersion()




        currentVersion.zip(minVersion).onEach {
            (appVersion, minVersion) ->
            println("appVersion: $appVersion, minVersion: $minVersion")
            if(appVersion != minVersion) {
                return appVersion > minVersion
            }
        }

        return true
    }
}