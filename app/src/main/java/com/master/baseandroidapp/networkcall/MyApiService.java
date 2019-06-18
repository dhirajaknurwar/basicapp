package com.master.baseandroidapp.networkcall;

import com.google.gson.JsonObject;
import com.master.baseandroidapp.models.GeneralResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Query;

public abstract  class MyApiService {

    private static MyApiService service;

    private static void setServiceType() {
        service = new CloudDataService();
    }

    public static MyApiService getService() {
        if (service == null) {
            setServiceType();
        }

        return service;
    }

    // create customer by admin
    public abstract Observable<GeneralResponse> getOtp(@Query("username") String username, @Query("name") String name, @Query("device_type") String device_type, @Query("device_token") String device_token);

    // create customer by admin
    public abstract Observable<GeneralResponse> doLogin(@Body JsonObject jsonObject);


}
