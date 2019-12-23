package com.anlh.kt.easypav.data.remote

import com.anlh.kt.easypav.data.model.LoginRequest
import com.anlh.kt.easypav.data.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

class APIEndpoint {

    interface UserService {

        @GET("/venues")
        fun getLogin(@Body loginRequest: LoginRequest): Call<LoginResponse>

    }

}
