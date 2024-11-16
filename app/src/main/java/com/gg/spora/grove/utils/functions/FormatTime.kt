package com.gg.spora.grove.utils.functions

import java.util.concurrent.TimeUnit

fun formatTime(timeInMillis: Long): String {
    val hours = TimeUnit.MILLISECONDS.toHours(timeInMillis)
    val minutes = TimeUnit.MILLISECONDS.toMinutes(timeInMillis) - TimeUnit.HOURS.toMinutes(hours)
    val seconds = TimeUnit.MILLISECONDS.toSeconds(timeInMillis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeInMillis))

    val hoursString = if (hours > 0) String.format("%02d:", hours) else ""
    val minutesString = if (hours > 0 || minutes > 0) String.format("%02d:", minutes) else "" // Show minutes if hours > 0
    val secondsString = if (hours > 0 || minutes > 0 || seconds > 0) String.format("%02d", seconds) else "" // Show seconds if hours or minutes > 0

    // Combine the strings, removing trailing colons if necessary
    var formattedTime = hoursString + minutesString + secondsString
    if (formattedTime.endsWith(":")) {
        formattedTime = formattedTime.substring(0, formattedTime.length - 1)
    }

    return formattedTime
}