package com.anlh.kt.easypav.modules.signIn.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.anlh.kt.easypav.core.SignInCommunicator
import com.anlh.kt.easypav.data.model.LoginRequest
import com.anlh.kt.easypav.modules.signIn.repository.UserRepository
import com.highflyers.commonresources.AppBaseViewModel
import kotlinx.coroutines.launch

class SignVM : AppBaseViewModel() {

    lateinit var listener: SignInCommunicator
    private val userRepository = UserRepository()
    var email = String()
    var password = String()

    override fun init() {

    }

    fun onSignInClick() {
        setLoadingData(true)
        viewModelScope.launch {
            val response = userRepository.getLogin(LoginRequest(email, password))
            if(response.isSuccessful){
                var loginResponse = response.body()
                listener.onLoginSuccessfull()
            }
            setLoadingData(false)
        }
    }

    fun onRegisterClick() {
        listener.onRegisterButtonClicked()
    }

    fun skipLogin() {
        listener.onSkipButtonClicked()
    }

    fun getSignInResponse() = signInResponse as LiveData<Boolean>
}