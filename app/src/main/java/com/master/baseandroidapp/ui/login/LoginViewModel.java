package com.master.baseandroidapp.ui.login;

import android.text.TextUtils;

import com.master.baseandroidapp.apputils.CommonUtils;
import com.master.baseandroidapp.models.GeneralResponse;
import com.master.baseandroidapp.networkcall.MyApiService;
import com.master.baseandroidapp.ui.base.BaseViewModel;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    private Disposable mGetOtpDisposable=null;

    public LoginViewModel() {


    }

    public boolean isEmailAndPasswordValid(String email, String password) {
        // validate email and password
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        if (!CommonUtils.isEmailValid(email)) {
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }

    public void login(String username, String name, String device_token, String device_type) {

        mGetOtpDisposable = MyApiService.getService().getOtp(username, name, device_token, device_type)
                .subscribe(new Consumer<GeneralResponse>() {
                    @Override
                    public void accept(GeneralResponse loginResponse) throws Exception {
                        //api_progress.setVisibility(View.INVISIBLE);
                        if (loginResponse.isSuccess()) {
                            mGetOtpDisposable.dispose();



                            getNavigator().openMainActivity();

                        } else {
                            //api_progress.setVisibility(View.INVISIBLE);
                            mGetOtpDisposable.dispose();
                        }
                    }

                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        //api_progress.setVisibility(View.INVISIBLE);
                        //displayError(getResources().getString(R.string.error_msg),
                          //      String.valueOf(throwable.getMessage()));
                        getNavigator().handleError(throwable);
                    }
                });


    }

    public void onServerLoginClick() {
        getNavigator().login();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (mGetOtpDisposable!=null){
            mGetOtpDisposable.dispose();
        }

    }
}
