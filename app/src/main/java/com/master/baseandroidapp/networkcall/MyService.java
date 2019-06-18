package com.master.baseandroidapp.networkcall;

import com.google.gson.JsonObject;
import com.master.baseandroidapp.models.GeneralResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyService {

    //USER
    /*get user get otp*/
    @GET(ApiEndPoints.GET_OTP_URL)
    Observable<GeneralResponse> getOtp(@Query("username") String username, @Query("name") String name, @Query("device_type") String device_type, @Query("device_token") String device_token);

    /*user login login*/
    @POST(ApiEndPoints.LOGIN_URL)
    Observable<GeneralResponse> doLogin(@Body JsonObject jsonObject);


}
