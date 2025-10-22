package com.gg.spora.core.domain

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetCurrentVersionUseCase @Inject constructor(
    @ApplicationContext private val context: Context
) {
    operator fun invoke() : List<Byte> {
        try {
            val pInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            // If pInfo.versionName is null, use "0.0.0" as a default value.
            val versionName = pInfo.versionName ?: "0.0.0"
            return versionName.split(".").map { it.toByte() }
        } catch (e: CurrentUserNotFoundException) { // Catch a more general Exception
            // It's better to return a default version here as well.
            return listOf(0,0,0)
        }
    }
}

class CurrentUserNotFoundException : Exception("Current user not found")