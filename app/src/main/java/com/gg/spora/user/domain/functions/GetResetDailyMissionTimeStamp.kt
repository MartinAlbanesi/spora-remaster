package com.gg.spora.user.domain.functions

import com.gg.spora.BuildConfig
import java.time.LocalDateTime
import java.time.ZoneId

fun getResetDailyMissionTimeStamp(): Long {
    return LocalDateTime.now()
        .plusHours(BuildConfig.HOURS)
        .plusMinutes(BuildConfig.MINUTES)
        .plusSeconds(BuildConfig.SECONDS)
        .atZone(ZoneId.systemDefault())
        .toEpochSecond()
}