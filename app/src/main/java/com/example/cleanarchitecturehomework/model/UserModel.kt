package com.example.cleanarchitecturehomework.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserModel(
    val name: String? = null,
    val surname: String? = null,
){ @PrimaryKey(autoGenerate = true)
    var id: Long = 0 }