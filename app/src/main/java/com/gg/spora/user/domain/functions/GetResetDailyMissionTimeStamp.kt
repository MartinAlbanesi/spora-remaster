package com.gg.spora.user.domain.functions

import java.time.LocalDateTime
import java.time.ZoneId

fun getResetDailyMissionTimeStamp(): Long {
    return LocalDateTime.now()
        .plusHours(23)
        .plusSeconds(59)
        .plusMinutes(59)
        .atZone(ZoneId.systemDefault())
        .toEpochSecond()
}