package com.example.cleanarchitecturehomework

import android.app.Application
import com.example.cleanarchitecturehomework.model.UsersRepository

class App : Application() {

    var usersRepository: UsersRepository? = null

    override fun onCreate() {
        super.onCreate()
        usersRepository = UsersRepository.getInstance(this)
    }

}