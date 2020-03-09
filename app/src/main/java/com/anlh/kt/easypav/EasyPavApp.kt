package com.anlh.kt.easypav

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.anlh.kt.easypav.core.AppPreferencesHelper
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EasyPavApp : Application() {

    //private AppPreferenceHelper preferenceHelper;
    //private AppRoomManager roomManager;

    override fun onCreate() {
        super.onCreate()
        instance = this
        FacebookSdk.sdkInitialize(applicationContext);
        AppEventsLogger.activateApp(this);
    }

    companion object {
        val retrofitInstance: Retrofit by lazy {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val request = chain.request()
                    val builder = request.newBuilder()
                    builder.method(request.method(), request.body())
                    builder.header("Content-Type", "application/json")
                    chain.proceed(builder.build())
                }.build()
            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }

        @get:Synchronized
        var instance: EasyPavApp? = null
            private set

    }
}