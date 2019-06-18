package com.master.baseandroidapp.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.master.baseandroidapp.MainActivity;
import com.master.baseandroidapp.R;
import com.master.baseandroidapp.ui.base.BaseActivity;

import androidx.lifecycle.ViewModelProviders;

public class LoginActivity extends BaseActivity<LoginViewModel> implements LoginNavigator {


    private LoginViewModel mLoginViewModel;

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }


    @Override
    public int getLayoutId() {
        return R.layout.login_activity_layout;
    }

    @Override
    public LoginViewModel getViewModel() {
        mLoginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        return mLoginViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {


    }

    @Override
    public void login() {

//        String email = mActivityLoginBinding.etEmail.getText().toString();
//        String password = mActivityLoginBinding.etPassword.getText().toString();
//        if (mLoginViewModel.isEmailAndPasswordValid(email, password)) {
//            hideKeyboard();
//            mLoginViewModel.login(email, password);
//        } else {
//            Toast.makeText(this, getString(R.string.invalid_email_password), Toast.LENGTH_SHORT).show();
//        }

    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.newIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void loadProgressBar(boolean showProgress) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginViewModel.setNavigator(this);
    }

}
