package com.anlh.kt.easypav.data.remote

import com.anlh.kt.easypav.data.database.entity.User
import com.anlh.kt.easypav.data.model.LoginRequest
import com.anlh.kt.easypav.data.model.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

class APIEndpoint {

    interface UserService {

        @POST("/users/login")
        suspend fun getLogin(@Body loginRequest: LoginRequest): Response<User>

        @POST("/users/register")
        suspend fun tryRegister(@Body registerRequest: RegisterRequest): Response<User>

    }

}
