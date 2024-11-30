package com.gg.spora.home.domain.functions

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

fun timeStampToLocalDateTime(timeStamp: Long): LocalDateTime {
    return Instant.ofEpochSecond(timeStamp)
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime()
}