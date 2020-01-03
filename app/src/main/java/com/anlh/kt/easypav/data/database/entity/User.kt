package com.anlh.kt.easypav.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    val id: Int,
    val name: String,
    val lastName: String,
    val email: String,
    val school: String)