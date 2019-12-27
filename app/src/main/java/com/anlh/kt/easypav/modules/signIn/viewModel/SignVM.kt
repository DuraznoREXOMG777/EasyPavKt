package com.anlh.kt.easypav.modules.signIn.viewModel

import android.view.View
import androidx.databinding.Bindable
import com.anlh.kt.easypav.core.SignInCommunicator
import com.highflyers.commonresources.AppBaseViewModel

class SignVM:AppBaseViewModel() {

    lateinit var listener: SignInCommunicator

    val email = String()
    val password = String()

    override fun init() {
    }

    fun onSignInClick(){
    }

    fun onRegisterClick(){
        listener.onRegisterButtonClicked()
    }

    fun skipLogin(){
        listener.onSkipButtonClicked()
    }

    fun setListener2(listener: SignInCommunicator){
        this.listener = listener
    }
}