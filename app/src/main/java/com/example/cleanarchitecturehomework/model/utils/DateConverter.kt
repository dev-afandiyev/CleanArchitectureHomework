package com.example.cleanarchitecturehomework.model.utils

import androidx.room.TypeConverter

class DateConverter {

    @TypeConverter
    fun toDate(timestamp: Long): java.sql.Date {
        return java.sql.Date(timestamp)
    }

    @TypeConverter
    fun toTimestamp(date: java.sql.Date): Long {
        return date.time
    }
}