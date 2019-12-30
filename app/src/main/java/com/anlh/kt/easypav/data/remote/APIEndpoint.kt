package com.anlh.kt.easypav.data.remote

import com.anlh.kt.easypav.data.model.LoginRequest
import com.anlh.kt.easypav.data.model.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

class APIEndpoint {

    interface UserService {

        @POST("/users/login")
        suspend fun getLogin(@Body loginRequest: LoginRequest): Response<LoginResponse>

    }

}
