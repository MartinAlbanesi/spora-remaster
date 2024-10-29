package com.gg.spora.grove.domain.mappers

import androidx.room.TypeConverter
import java.time.Duration

object DurationConverter {
    @TypeConverter
    fun toDuration(value: Long): Duration {
        return Duration.ofMillis(value) // Or Duration.ofNanos(value) if storing in nanoseconds
    }

    @TypeConverter
    fun fromDuration(duration: Duration): Long {
        return duration.toMillis() // Or duration.toNanos() if storing in nanoseconds
    }
}