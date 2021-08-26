package com.example.cleanarchitecturehomework.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserModel(
    val name: String? = null,
    val surname: String? = null,
//    @TypeConverters(DateConverter::class)
//    val date: Date? = null,
//    val created: String? = null,
){ @PrimaryKey(autoGenerate = true)
    var id: Long = 0 }