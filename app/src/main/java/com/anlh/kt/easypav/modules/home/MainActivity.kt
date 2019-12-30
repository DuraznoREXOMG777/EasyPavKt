package com.anlh.kt.easypav.modules.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.anlh.kt.easypav.R
import com.anlh.kt.easypav.data.model.LoginResponse
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginResponse = Gson().fromJson(intent.getStringExtra("ETS"),LoginResponse::class.java)

    }
}
