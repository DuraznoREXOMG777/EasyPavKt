package com.anlh.kt.easypav.modules.signIn.repository

import com.anlh.kt.easypav.EasyPavApp
import com.anlh.kt.easypav.data.database.dao.UserDao
import com.anlh.kt.easypav.data.database.entity.User
import com.anlh.kt.easypav.data.model.LoginRequest
import com.anlh.kt.easypav.data.model.RegisterRequest
import com.anlh.kt.easypav.data.remote.APIEndpoint
import retrofit2.Response

class UserRepository(private val userDao: UserDao) {

    private val userService: APIEndpoint.UserService
        get() = EasyPavApp.retrofitInstance.create(APIEndpoint.UserService::class.java)

    suspend fun getLogin(loginRequest: LoginRequest) : Response<User> {
        return userService.getLogin(loginRequest)
    }

    suspend fun tryRegister(registerRequest: RegisterRequest) : Response<User> {
        return userService.tryRegister(registerRequest)
    }

    suspend fun insert(user: User){
        userDao.insert(user)
    }


}