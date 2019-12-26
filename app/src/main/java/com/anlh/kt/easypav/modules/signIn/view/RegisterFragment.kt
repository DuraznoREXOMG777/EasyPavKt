package com.anlh.kt.easypav.modules.signIn.view

import androidx.lifecycle.ViewModelProviders
import com.anlh.kt.easypav.R
import com.anlh.kt.easypav.databinding.FragmentRegisterBinding
import com.anlh.kt.easypav.databinding.FragmentSignInBinding
import com.anlh.kt.easypav.modules.signIn.viewModel.SignInVM
import com.highflyers.commonresources.AppBaseFragment

class RegisterFragment: AppBaseFragment<FragmentRegisterBinding, SignInVM>() {

    private lateinit var viewModel : SignInVM

    override fun getBindingVariable(): Int {
        return 1
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_register
    }

    override fun getViewModel(): SignInVM {
        viewModel = ViewModelProviders.of(this).get(SignInVM::class.java)
        return viewModel
    }

}