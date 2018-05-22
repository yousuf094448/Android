package com.chef.app.demo.DataRepository.RetroWebServices;

import com.chef.app.demo.DataRepository.RetroWebServices.Beans.DeliveryListBean;
import com.chef.app.demo.DataRepository.RetroWebServices.Beans.Example;
import com.chef.app.demo.DataRepository.RetroWebServices.Beans.PickUpListBean;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroWebServiceApi {
//    @GET("retrofit/json_object.json")
//    Call<PickUpListBean> getMyJSON();

    @GET("contacts/")
    Call<Example> getMyContacts();

    @GET("contacts/")
    Call<PickUpListBean> getPickUpList();

    @GET("contacts/")
    Call<DeliveryListBean> getDeliveryList();
}
