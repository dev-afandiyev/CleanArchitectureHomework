package com.example.cleanarchitecturehomework.db

import androidx.room.*
import com.example.cleanarchitecturehomework.model.UserModel

@Database(entities = [UserModel::class], version = 1)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun usersDao(): IUsersDao?
}
