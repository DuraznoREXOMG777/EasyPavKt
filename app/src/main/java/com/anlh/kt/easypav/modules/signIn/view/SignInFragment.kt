package com.anlh.kt.easypav.modules.signIn.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.anlh.kt.easypav.BR
import com.anlh.kt.easypav.R
import com.anlh.kt.easypav.core.SignInCommunicator
import com.anlh.kt.easypav.databinding.FragmentLogInBinding
import com.anlh.kt.easypav.modules.signIn.viewModel.SignVM
import com.anlh.kt.easypav.util.showToast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.highflyers.commonresources.AppBaseFragment



class SignInFragment: AppBaseFragment<FragmentLogInBinding, SignVM>() {

    private lateinit var viewModel : SignVM
    private lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun getBindingVariable(): Int =  BR.signVM


    override fun getLayoutId(): Int  = R.layout.fragment_log_in


    override fun getViewModel(): SignVM {
        viewModel = ViewModelProviders.of(this).get(SignVM::class.java)
        return viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.listener = this.baseActivity as SignInCommunicator

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(baseActivity, gso)

        setUpLoginButtons()
    }

    private fun setUpLoginButtons() {
        viewDataBinding.buttonGoogleSignIn.setOnClickListener {
            val signInIntent: Intent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            RC_SIGN_IN -> {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                handleSignInResult(task)
            }
        }
    }

    private fun handleSignInResult(task: Task<GoogleSignInAccount>?) {
        try {
            val account: GoogleSignInAccount? = task?.getResult(ApiException::class.java)
            // Signed in successfully, show authenticated UI.
            context?.showToast("Successful")
        } catch (e: ApiException) { // The ApiException status code indicates the detailed failure reason.

            Log.w(TAG, "signInResult:failed code=" + e.statusCode)
            context?.showToast("Failed")
        }
    }

    companion object {
        private const val RC_SIGN_IN = 200
        private const val TAG = "SIGN_IN"
    }

}