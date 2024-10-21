package com.gg.spora.miniGames.domain.functions

import android.content.Context

fun getResourceImageFromString(
    context: Context,
    resourcesString: String,
): Int {
    return context.resources.getIdentifier(resourcesString, "drawable", context.packageName)
}