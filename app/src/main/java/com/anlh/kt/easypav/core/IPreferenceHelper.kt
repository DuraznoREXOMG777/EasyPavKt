package com.anlh.kt.easypav.core

interface IPreferenceHelper {
    fun setFirstOpen(open:Boolean)
    fun getFirstOpen():Boolean

    fun setUser(user:String)
    fun getUser():String?

}