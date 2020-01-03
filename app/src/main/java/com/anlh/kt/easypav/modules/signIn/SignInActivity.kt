package com.anlh.kt.easypav.modules.signIn

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.anlh.kt.easypav.BR
import com.anlh.kt.easypav.R
import com.anlh.kt.easypav.core.AppUtil
import com.anlh.kt.easypav.core.SignInCommunicator
import com.anlh.kt.easypav.databinding.ActivitySignInBinding
import com.anlh.kt.easypav.modules.home.MainActivity
import com.anlh.kt.easypav.modules.signIn.view.RegisterFragment
import com.anlh.kt.easypav.modules.signIn.view.SignInFragment
import com.anlh.kt.easypav.modules.signIn.viewModel.SignVM
import com.anlh.kt.easypav.util.AppConstants
import com.anlh.kt.easypav.util.views.AppDialogFragment
import com.google.gson.Gson
import com.highflyers.commonresources.AppBaseActivity

class SignInActivity : AppBaseActivity<ActivitySignInBinding, SignVM>(), SignInCommunicator {

    private lateinit var viewModel : SignVM
    private var appDialogFragment: AppDialogFragment? = null

    override fun getBindingVariable(): Int {
        return BR.signVM
    }

    override fun getViewModel(): SignVM {
        viewModel = ViewModelProviders.of(this).get(SignVM::class.java)
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
        AppUtil.appPreferencesHelper.setFirstOpen(false)
        addFragment(SignInFragment(), AppConstants.FRAGMENT_SIGN_IN_TAG)

    }

    override fun showLoader(isLoading: Boolean) {
        if(isLoading){
            appDialogFragment = AppDialogFragment.newInstance(AppConstants.DIALOG_TYPE_LOADER)
            appDialogFragment?.show(supportFragmentManager, AppConstants.FRAGMENT_DIALOG_TAG)
        }else{
            appDialogFragment?.dismiss()
            appDialogFragment = null
        }
    }

    override fun showDialog(type: Int, message: String) {
        appDialogFragment = AppDialogFragment.newInstance(type, message)
        appDialogFragment?.show(supportFragmentManager, AppConstants.FRAGMENT_DIALOG_TAG)
    }

    override fun onRegisterButtonClicked() {
        replaceFragment(RegisterFragment(), AppConstants.FRAGMENT_REGISTER_TAG)
    }

    override fun onSkipButtonClicked() {
        startActivity(Intent(this@SignInActivity, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }

    override fun onLoginSuccessful() {
        startActivity(Intent(this@SignInActivity, MainActivity::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }
}
