package com.chef.app.demo.DataRepository.RetroWebServices;

import com.chef.app.demo.DataRepository.RetroWebServices.Beans.Example;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroWebServiceApi {
//    @GET("retrofit/json_object.json")
//    Call<PickUpListBean> getMyJSON();

    @GET("contacts/")
    Call<Example> getMyContacts();
}
