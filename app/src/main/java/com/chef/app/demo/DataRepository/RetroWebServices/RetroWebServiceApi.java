package com.chef.app.demo.DataRepository.RetroWebServices;

import com.chef.app.demo.DataRepository.LogIn.LogIn;
import com.chef.app.demo.DataRepository.RetroWebServices.Delivery.RetroDelivery;
import com.chef.app.demo.DataRepository.Model.DeliveryListBean;
import com.chef.app.demo.DataRepository.Model.Example;
import com.chef.app.demo.DataRepository.RetroWebServices.PickUp.RetroPickUp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface RetroWebServiceApi {
//    @GET("retrofit/json_object.json")
//    Call<PickUpListBean> getMyJSON();

    @FormUrlEncoded
    @POST("Account/Login")
    Call<LogIn> logIn(@Field("Email") String email, @Field("Password") String password);


    @GET("contacts/")
    Call<Example> getMyContacts();

    @GET("Delivery/GetPickUpListByDeliveryMan/{deliveryMan_id}/{date}/{page}/")
    Call<RetroPickUp> getPickUpList(@Path("deliveryMan_id") String deliveryMan_id, @Path("date") String date, @Path("page") String page);

    @GET
    Call<RetroPickUp> getPickUpList2(@Url String url);

    @GET
    Call<RetroDelivery> getDeliveryList(@Url String url);

    @GET("contacts/")
    Call<DeliveryListBean> getDeliveryList();
}
