package com.example.cleanarchitecturehomework.viewmodel

import com.example.cleanarchitecturehomework.App
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.cleanarchitecturehomework.model.UserModel
import com.example.cleanarchitecturehomework.model.UsersRepository

class MainViewModel(private val application: App) : AndroidViewModel(application) {

    private val usersRepository = application.usersRepository

    fun getAllUsers(): LiveData<List<UserModel>>? {
        return usersRepository?.getAllItem()
    }

}