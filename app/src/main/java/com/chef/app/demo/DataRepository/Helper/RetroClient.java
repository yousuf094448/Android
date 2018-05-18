package com.chef.app.demo.DataRepository.Helper;

import com.chef.app.demo.DataRepository.WebServices.WebService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    /********
     * URLS
     *******/
    private static final String ROOT_URL = "http://api.androiddeft.com/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static WebService getApiService() {
        return getRetrofitInstance().create(WebService.class);
    }
}
