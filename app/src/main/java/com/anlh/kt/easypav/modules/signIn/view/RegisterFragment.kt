package com.anlh.kt.easypav.modules.signIn.view

import androidx.lifecycle.ViewModelProviders
import com.anlh.kt.easypav.R
import com.anlh.kt.easypav.databinding.FragmentRegisterBinding
import com.anlh.kt.easypav.databinding.FragmentSignInBinding
import com.anlh.kt.easypav.modules.signIn.viewModel.SignInVM
import com.anlh.kt.easypav.modules.signIn.viewModel.SignVM
import com.highflyers.commonresources.AppBaseFragment

class RegisterFragment: AppBaseFragment<FragmentRegisterBinding, SignVM>() {

    private lateinit var viewModel : SignVM

    override fun getBindingVariable(): Int {
        return 1
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_register
    }

    override fun getViewModel(): SignVM {
        viewModel = ViewModelProviders.of(this).get(SignVM::class.java)
        return viewModel
    }

}