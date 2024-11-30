package com.gg.spora.home.domain.functions

import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

fun formatDuration(duration: Duration): String {
    val hours = duration.inWholeHours
    val minutes = (duration - hours.hours).inWholeMinutes
    val seconds = (duration - hours.hours - minutes.minutes).inWholeSeconds
    return "${hours}h ${minutes}m ${seconds}s"
}