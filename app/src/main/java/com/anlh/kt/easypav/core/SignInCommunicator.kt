package com.anlh.kt.easypav.core

interface SignInCommunicator {
    fun onRegisterButtonClicked()
    fun onSkipButtonClicked()
    fun onLoginSuccessful()
    fun showLoader(isLoading:Boolean)
    fun showDialog(type:Int, message:String)
}