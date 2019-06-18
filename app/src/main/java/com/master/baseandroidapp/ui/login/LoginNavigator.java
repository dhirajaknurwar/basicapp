package com.master.baseandroidapp.ui.login;

public interface LoginNavigator {

    void handleError(Throwable throwable);

    void login();

    void openMainActivity();

    void loadProgressBar(boolean showProgress);


}
