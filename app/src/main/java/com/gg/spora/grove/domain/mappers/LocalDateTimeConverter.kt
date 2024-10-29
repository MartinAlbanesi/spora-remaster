package com.gg.spora.grove.domain.mappers

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

object LocalDateTimeConverter {
    @TypeConverter
    fun toLocalDateTime(value: Long): LocalDateTime {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneId.systemDefault())
    }

    @TypeConverter
    fun fromLocalDateTime(date: LocalDateTime): Long {
        return date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
    }
}