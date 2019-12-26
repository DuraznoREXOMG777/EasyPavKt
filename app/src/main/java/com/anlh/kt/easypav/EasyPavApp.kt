package com.anlh.kt.easypav

import android.app.Application
import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EasyPavApp : Application() {

    private var retrofit: Retrofit? = null
    //private AppPreferenceHelper preferenceHelper;
    //private AppRoomManager roomManager;

    val context: Context
        get() = applicationContext

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val request = chain.request()
                        val builder = request.newBuilder()
                        builder.method(request.method(), request.body())
                        builder.header("Content-Type", "application/json")
                        chain.proceed(builder.build())
                    }.build()
            retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
            return retrofit as Retrofit
        } else {
            return retrofit as Retrofit
        }
    }

    companion object {
        @get:Synchronized
        var instance: EasyPavApp? = null
            private set
    }


}
