package com.anlh.kt.easypav.core

import com.anlh.kt.easypav.data.model.LoginResponse

interface SignInCommunicator {
    fun onRegisterButtonClicked()
    fun onSkipButtonClicked()
    fun onLoginSuccessfull(loginResponse: LoginResponse)
}