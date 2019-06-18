package com.master.baseandroidapp;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    public static final String TAG = MyApplication.class.getSimpleName();

    private static MyApplication _instance;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;

    }

    public static MyApplication getInstance() {
        return _instance;
    }

}
