package com.gg.spora.core.domain

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetCurrentVersionUseCase @Inject constructor(
    @ApplicationContext private val context: Context
) {
    operator fun invoke() : List<Byte> {
        try {
            val currentVersion = context.packageManager.getPackageInfo(context.packageName, 0)
            return currentVersion.versionName.split(".").map { it.toByte() }
        } catch (e: CurrentUserNotFoundException) {
            return listOf(0,0,0)
        }
    }
}

class CurrentUserNotFoundException : Exception("Current user not found")