package com.teamaad34.polls.utils

import androidx.room.TypeConverter
import com.google.firebase.Timestamp
import java.util.*

class TimestampConverter {
    @TypeConverter
    fun fromTimestampToInt(timestamp: Timestamp): Long = timestamp.toDate().time

    @TypeConverter
    fun fromIntToTimestamp(timestamp: Long): Timestamp = Timestamp(Date(timestamp))
}