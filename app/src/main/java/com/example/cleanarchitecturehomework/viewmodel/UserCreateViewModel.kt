package com.example.cleanarchitecturehomework.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecturehomework.App
import com.example.cleanarchitecturehomework.model.UserModel

class UserCreateViewModel(private val application: App) : AndroidViewModel(application) {

    private val usersRepository = application.usersRepository
    val insertUsersState: MutableLiveData<UserModel> = MutableLiveData<UserModel>()

    fun insert(name: String, surname: String) {
        usersRepository?.insert(UserModel(name, surname))
    }

}