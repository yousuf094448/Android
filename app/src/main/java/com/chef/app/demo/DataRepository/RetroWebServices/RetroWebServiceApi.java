package com.chef.app.demo.DataRepository.RetroWebServices;

import com.chef.app.demo.DataRepository.LogIn.LogIn;
import com.chef.app.demo.DataRepository.Model.DeliveryListBean;
import com.chef.app.demo.DataRepository.Model.Example;
import com.chef.app.demo.DataRepository.Model.PickUpList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetroWebServiceApi {
//    @GET("retrofit/json_object.json")
//    Call<PickUpListBean> getMyJSON();

    @FormUrlEncoded
    @POST("Account/Login")
    Call<LogIn> logIn(@Field("Email") String email,
                      @Field("Password") String password);

    @GET("contacts/")
    Call<Example> getMyContacts();

    @GET("contacts/")
    Call<PickUpList> getPickUpList();

    @GET("contacts/")
    Call<DeliveryListBean> getDeliveryList();
}
