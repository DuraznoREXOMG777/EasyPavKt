package com.anlh.kt.easypav.modules.signIn

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.anlh.kt.easypav.BR
import com.anlh.kt.easypav.R
import com.anlh.kt.easypav.core.SignInCommunicator
import com.anlh.kt.easypav.databinding.ActivitySignInBinding
import com.anlh.kt.easypav.modules.home.MainActivity
import com.anlh.kt.easypav.modules.signIn.view.RegisterFragment
import com.anlh.kt.easypav.modules.signIn.view.SignInFragment
import com.anlh.kt.easypav.modules.signIn.viewModel.SignInVM
import com.anlh.kt.easypav.util.AppConstants
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
        return R.id.fragment_container
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(SignInFragment(), AppConstants.FRAGMENT_SIGN_IN_TAG)
    }

    override fun onRegisterButtonClicked() {
        replaceFragment(RegisterFragment(), AppConstants.FRAGMENT_REGISTER_TAG)
    }

    override fun onSkipButtonClicked() {
        startActivity(Intent(this@SignInActivity, MainActivity::class.java))
    }
}
