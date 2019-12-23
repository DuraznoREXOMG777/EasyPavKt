package com.highflyers.commonresources;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.highflyers.commonresources.utils.NetworkUtils;

public abstract class AppBaseActivity<T extends ViewDataBinding, V extends AppBaseViewModel> extends AppCompatActivity implements AppBaseFragment.Callback {

    private T mViewDataBinding;
    private V mViewModel;

    /**
     * Override for set binding variable
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * Override for set view model
     * @return view model instance
     */
    public abstract V getViewModel();

    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    public abstract
    @LayoutRes
    int getLayoutId();


    protected @IdRes
    int getFragmentContainerId() { return 0; }
    protected boolean fullScreenConfiguration() {
        return false;
    }
    //protected boolean displayHomeAsUp() { return false; }
    //protected Toolbar getToolbarReference() { return null; }
    protected String tag() { return this.getClass().getSimpleName(); }


    protected void replaceFragment(Fragment fragment, String tag){
        replaceFragment(fragment, tag, true, true);
    }

    protected void replaceFragment(Fragment fragment, String tag, boolean enterAnimation, boolean exitAnimation){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(enterAnimation && exitAnimation)
            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        else if(enterAnimation)
            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        else if(exitAnimation)
            transaction.setCustomAnimations(0, 0, R.anim.enter_from_left, R.anim.exit_to_right);
        transaction.replace(getFragmentContainerId(), fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    protected void addFragment(Fragment fragment, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(getFragmentContainerId(), fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    protected void printInLogCat(String message){
        Log.i(tag(), message);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (fullScreenConfiguration()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        performDataBinding();
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    private void performDataBinding() {
        if (getViewModel() != null) {
            mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
            this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
            mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
            mViewDataBinding.executePendingBindings();
        }
    }


}
