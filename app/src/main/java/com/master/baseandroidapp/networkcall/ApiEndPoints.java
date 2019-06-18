package com.master.baseandroidapp.networkcall;

import com.master.baseandroidapp.BuildConfig;

public class ApiEndPoints {

    public static final String GET_OTP_URL = BuildConfig.BASE_URL + "/5926ce9d11000096006ccb30";

    public static final String LOGIN_URL = BuildConfig.BASE_URL + "/588d15d3100000ae072d2944";

    public static final String GET_USER_DETAIL_URL = BuildConfig.BASE_URL + "/588d14f4100000a9072d2943";

    public static final String USER_LOGOUT = BuildConfig.BASE_URL + "/588d161c100000a9072d2946";

    private ApiEndPoints() {
        // This class is not publicly instantiable
    }

}
