package com.anlh.kt.easypav.modules.signIn.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.anlh.kt.easypav.core.SignInCommunicator
import com.anlh.kt.easypav.data.model.LoginRequest
import com.anlh.kt.easypav.modules.signIn.repository.UserRepository
import com.highflyers.commonresources.AppBaseViewModel
import kotlinx.coroutines.launch

class SignVM : AppBaseViewModel() {

    lateinit var listener: SignInCommunicator
    private val userRepository = UserRepository()
    var email = "contacto.anlh@gmail.com"
    var password = "1lseplax"

    private val loading = MutableLiveData<Boolean>()

    val _loading: LiveData<Boolean>
        get() = loading

    override fun init() {

    }

    fun onSignInClick() {
        listener.showLoader(true)
        viewModelScope.launch {
            val response = userRepository.getLogin(LoginRequest(email, password))
            listener.showLoader(false)
            if(response.isSuccessful){
                listener.onLoginSuccessful(response.body()!!)
            }
        }
    }

    fun onRegisterClick() {
        listener.onRegisterButtonClicked()
    }

    fun skipLogin() {
        listener.onSkipButtonClicked()
    }

}