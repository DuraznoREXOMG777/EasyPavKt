package com.anlh.kt.easypav.data.remote

interface APIListener<T> {
    fun onSuccess(item: T)
    fun onFailure(message: String)
}
