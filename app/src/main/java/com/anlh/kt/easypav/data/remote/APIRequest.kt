package com.anlh.kt.easypav.data.remote


import com.anlh.kt.easypav.EasyPavApp
import com.anlh.kt.easypav.data.model.LoginRequest
import com.anlh.kt.easypav.data.model.LoginResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object APIRequest {


    private val userService: APIEndpoint.UserService
        get() = EasyPavApp.instance!!.getRetrofit().create(APIEndpoint.UserService::class.java)

    fun getLogin(request: LoginRequest, listener: APIListener<LoginResponse>): Call<LoginResponse>? {

        val call = userService.getLogin(request)

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (call.isCanceled)
                    return
                if (response.isSuccessful) {
                    val user = response.body()
                    user?.let { listener.onSuccess(it) }
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

            }
        })
        return null
    }
}
