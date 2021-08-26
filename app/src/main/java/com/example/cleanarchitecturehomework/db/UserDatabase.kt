package com.example.cleanarchitecturehomework.db

import android.content.Context
import androidx.room.*
import com.example.cleanarchitecturehomework.model.UserModel

@Database(entities = [UserModel::class], version = 1)
//@TypeConverters(DateConverter::class)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun usersDao(): IUsersDao?

    companion object {
        private var instance: UsersDatabase? = null

        fun getInstance(context: Context): UsersDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    UsersDatabase::class.java, "database"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }

}
