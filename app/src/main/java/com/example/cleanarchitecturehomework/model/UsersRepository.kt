package com.example.cleanarchitecturehomework.model

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.cleanarchitecturehomework.App
import com.example.cleanarchitecturehomework.db.IUsersDao
import com.example.cleanarchitecturehomework.db.UsersDatabase

class UsersRepository() : IUserRepository {
    private var usersDao: IUsersDao? = null

   companion object {
       private var mInstance: UsersRepository? = null
       private var usersDao: IUsersDao? = null

       fun getInstance(application: App?): UsersRepository? {
           if (mInstance == null) {
               mInstance = UsersRepository()
               val database = application?.let { UsersDatabase.getInstance(it) }
               usersDao = database!!.usersDao()
           }
           return mInstance
       }
   }

    override fun getAllItem(): LiveData<List<UserModel>> {
       return usersDao?.getAllUsers()!!
    }

    override fun insert(userModel: UserModel) {
        usersDao?.insert(userModel)
    }

}