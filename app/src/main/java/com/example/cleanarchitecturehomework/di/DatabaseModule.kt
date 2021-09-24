package com.example.cleanarchitecturehomework.di

import android.content.Context
import androidx.room.Room
import com.example.cleanarchitecturehomework.db.IUsersDao
import com.example.cleanarchitecturehomework.db.UsersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase (@ApplicationContext appContext: Context): UsersDatabase {
        return Room.databaseBuilder (
            appContext,
            UsersDatabase::class.java, "database"
        )
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun provideUsersDao(appDatabase: UsersDatabase): IUsersDao {
        return appDatabase.usersDao()!!
    }

}