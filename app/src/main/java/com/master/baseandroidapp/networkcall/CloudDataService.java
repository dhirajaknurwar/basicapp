package com.master.baseandroidapp.networkcall;

import com.google.gson.JsonObject;
import com.master.baseandroidapp.models.GeneralResponse;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class CloudDataService extends MyApiService {

    //Holds service instance
    private MyService service;

    // Constructor
    CloudDataService() {
        service = new RetrofitHelper().getMyService();
    }


    @Override
    public Observable<GeneralResponse> getOtp(String username, String name, String device_type, String device_token) {
        return service.getOtp(username, name, device_type, device_token)
                .subscribeOn(Schedulers.io()) // “work” on io thread
                .observeOn(AndroidSchedulers.mainThread()); // “listen” on UIThread;
    }

    @Override
    public Observable<GeneralResponse> doLogin(JsonObject jsonObject) {
        return service.doLogin(jsonObject)
                .subscribeOn(Schedulers.io()) // “work” on io thread
                .observeOn(AndroidSchedulers.mainThread()); // “listen” on UIThread;
    }


}
