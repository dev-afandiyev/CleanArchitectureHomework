package com.example.cleanarchitecturehomework

import android.app.Application
import android.content.Context
import com.example.cleanarchitecturehomework.model.UsersRepository

class App : Application() {

    var usersRepository: UsersRepository? = null

    override fun onCreate() {
        super.onCreate()
//        usersRepository = UsersRepository.getInstance(this)
    }

}