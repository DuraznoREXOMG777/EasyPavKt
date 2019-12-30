package com.anlh.kt.easypav.modules.signIn.repository

import com.anlh.kt.easypav.EasyPavApp
import com.anlh.kt.easypav.data.model.LoginRequest
import com.anlh.kt.easypav.data.model.LoginResponse
import com.anlh.kt.easypav.data.remote.APIEndpoint
import retrofit2.Response

class UserRepository {

    private val userService: APIEndpoint.UserService
        get() = EasyPavApp.retrofitInstance.create(APIEndpoint.UserService::class.java)

    suspend fun getLogin(loginRequest: LoginRequest) : Response<LoginResponse> {
        return userService.getLogin(loginRequest)
    }


}