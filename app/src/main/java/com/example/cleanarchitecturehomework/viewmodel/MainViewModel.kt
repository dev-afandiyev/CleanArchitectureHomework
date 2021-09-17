package com.example.cleanarchitecturehomework.viewmodel

import android.app.Application
import com.example.cleanarchitecturehomework.App
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.cleanarchitecturehomework.model.UserModel
import com.example.cleanarchitecturehomework.model.UsersRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val usersRepository = UsersRepository(application)

    fun getAllUsers(): LiveData<List<UserModel>>? {
        return usersRepository?.getAllItem()
    }

}