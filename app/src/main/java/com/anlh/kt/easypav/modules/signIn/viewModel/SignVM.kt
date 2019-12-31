package com.anlh.kt.easypav.modules.signIn.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import com.anlh.kt.easypav.EasyPavApp
import com.anlh.kt.easypav.core.SignInCommunicator
import com.anlh.kt.easypav.data.model.ErrorResponse
import com.anlh.kt.easypav.data.model.LoginRequest
import com.anlh.kt.easypav.modules.signIn.repository.UserRepository
import com.anlh.kt.easypav.util.AppConstants
import com.google.gson.Gson
import com.highflyers.commonresources.AppBaseViewModel
import kotlinx.coroutines.launch
import kotlin.math.log

class SignVM : AppBaseViewModel() {

    lateinit var listener: SignInCommunicator
    private val userRepository = UserRepository()
    var email = "contacto.anlh@gmail.com"
    var password = "1lseplx"

    override fun init() {

    }

    fun onSignInClick() {
        listener.showLoader(true)
        viewModelScope.launch {
            val response = userRepository.getLogin(LoginRequest(email, password))
            listener.showLoader(false)
            if(response.isSuccessful){
                listener.onLoginSuccessful(response.body()!!)
            }else{
                val error: ErrorResponse = Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
                listener.showDialog(AppConstants.DIALOG_TYPE_ERROR, error.message)
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