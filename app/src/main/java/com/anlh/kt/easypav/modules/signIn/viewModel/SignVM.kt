package com.anlh.kt.easypav.modules.signIn.viewModel

import androidx.lifecycle.viewModelScope
import com.anlh.kt.easypav.EasyPavApp
import com.anlh.kt.easypav.core.AppRoom
import com.anlh.kt.easypav.core.SignInCommunicator
import com.anlh.kt.easypav.data.model.ErrorResponse
import com.anlh.kt.easypav.data.model.LoginRequest
import com.anlh.kt.easypav.data.model.RegisterRequest
import com.anlh.kt.easypav.modules.signIn.repository.UserRepository
import com.anlh.kt.easypav.util.AppConstants
import com.google.gson.Gson
import com.highflyers.commonresources.AppBaseViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.*

class SignVM : AppBaseViewModel() {

    lateinit var listener: SignInCommunicator
    private val userRepository = UserRepository(AppRoom.getDatabase(EasyPavApp.instance!!.applicationContext).userDao())

    var email = "contacto.anlh@gmail.com"
    var password = "1lseplax"

    var name = "Antonio"
    var lastName = "Antonio"

    override fun init() {

    }

    fun onSignInClick() {
        listener.showLoader(true)
        viewModelScope.launch {
            val response = userRepository.getLogin(LoginRequest(email, password))
            listener.showLoader(false)
            if(response.isSuccessful){
                userRepository.insert(response.body()!!)
                listener.onLoginSuccessful()
            }else{

            }
        }
    }

    fun onRegisterClick() {
        listener.onRegisterButtonClicked()
    }

    fun skipLogin() {
        listener.onSkipButtonClicked()
    }

    fun onCreateNewUserClick(){
        viewModelScope.launch {
            val response = userRepository.tryRegister(RegisterRequest(name, lastName, email, password, ""))
            if(response.isSuccessful){

            }else{

            }
        }
    }

    private fun showError(response : Response<Object>){
        val error: ErrorResponse = Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
        listener.showDialog(AppConstants.DIALOG_TYPE_ERROR, error.message)
    }

}