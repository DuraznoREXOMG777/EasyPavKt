package com.anlh.kt.easypav.modules.signIn

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.anlh.kt.easypav.BR
import com.anlh.kt.easypav.R
import com.anlh.kt.easypav.core.SignInCommunicator
import com.anlh.kt.easypav.databinding.ActivitySignInBinding
import com.anlh.kt.easypav.modules.signIn.viewModel.SignInVM
import com.highflyers.commonresources.AppBaseActivity

class SignInActivity : AppBaseActivity<ActivitySignInBinding, SignInVM>(), SignInCommunicator {

    private lateinit var viewModel : SignInVM

    override fun getBindingVariable(): Int {
        return BR.signInVM
    }

    override fun getViewModel(): SignInVM {
        viewModel = ViewModelProviders.of(this).get(SignInVM::class.java)
        return viewModel
    }

    override fun onFragmentAttached() {

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_sign_in
    }

    override fun onFragmentDetached(tag: String?) {
    }

    override fun fullScreenConfiguration(): Boolean {
        return true
    }

    override fun getFragmentContainerId(): Int {
        return R.id.frame_sign_in
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onRegisterButtonClicked() {

    }
}
