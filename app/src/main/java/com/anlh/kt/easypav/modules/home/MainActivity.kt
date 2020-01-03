package com.anlh.kt.easypav.modules.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anlh.kt.easypav.R
import com.anlh.kt.easypav.data.database.entity.User
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginResponse = Gson().fromJson(intent.getStringExtra("ETS"),User::class.java)

    }
}
