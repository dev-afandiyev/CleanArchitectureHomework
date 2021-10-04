package com.example.cleanarchitecturehomework.model

import androidx.lifecycle.LiveData
import com.example.cleanarchitecturehomework.db.IUsersDao
import javax.inject.Inject

class UsersRepository @Inject constructor(private var usersDao: IUsersDao) : IUserRepository {

    override fun getAllItem(): LiveData<List<UserModel>> {
       return usersDao?.getAllUsers()!!
    }

    override fun insert(userModel: UserModel) {
        usersDao?.insert(userModel)
    }

}