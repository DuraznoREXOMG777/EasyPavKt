package com.anlh.kt.easypav.data.model

data class RegisterRequest(
    val name: String,
    val lastName: String,
    val email: String,
    val password: String,
    val school: String
)