package com.example.cleanarchitecturehomework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturehomework.model.UserModel
import com.example.cleanarchitecturehomework.model.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserCreateViewModel @Inject constructor(private val repository: UsersRepository)
    : ViewModel() {

    val insertUsersState: MutableLiveData<UserModel> = MutableLiveData<UserModel>()

    fun insert(name: String, surname: String) {
        repository?.insert(UserModel(name, surname))
    }

}