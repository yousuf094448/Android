package com.chef.app.demo.DataRepository.RetroWebServices;

import com.chef.app.demo.DataRepository.RetroWebServices.RetroWebServiceApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    /********
     * URLS
     *******/
    private static final String ROOT_URL = "https://api.androidhive.info/";

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
    public static RetroWebServiceApi getApiService() {
        return getRetrofitInstance().create(RetroWebServiceApi.class);
    }
}
