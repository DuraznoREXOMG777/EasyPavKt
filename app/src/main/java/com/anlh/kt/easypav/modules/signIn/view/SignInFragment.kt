package com.anlh.kt.easypav.modules.signIn.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anlh.kt.easypav.BR
import com.anlh.kt.easypav.R
import com.anlh.kt.easypav.core.SignInCommunicator
import com.anlh.kt.easypav.databinding.FragmentSignInBinding
import com.anlh.kt.easypav.modules.signIn.viewModel.SignVM
import com.highflyers.commonresources.AppBaseFragment

class SignInFragment: AppBaseFragment<FragmentSignInBinding, SignVM>() {

    private lateinit var viewModel : SignVM

    override fun getBindingVariable(): Int {
        return BR.signVM
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_sign_in
    }

    override fun getViewModel(): SignVM {
        viewModel = ViewModelProviders.of(this).get(SignVM::class.java)
        return viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.listener = this.baseActivity as SignInCommunicator
    }
}