package com.example.cleanarchitecturehomework.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturehomework.model.UserModel
import com.example.cleanarchitecturehomework.model.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: UsersRepository)
    : ViewModel() {

    fun getAllUsers(): LiveData<List<UserModel>>? {
        return repository?.getAllItem()
    }

}