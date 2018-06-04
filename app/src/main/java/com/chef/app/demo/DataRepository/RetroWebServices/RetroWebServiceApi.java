package com.chef.app.demo.DataRepository.RetroWebServices;

import com.chef.app.demo.DataRepository.Model.DeliveryListBean;
import com.chef.app.demo.DataRepository.Model.Example;
import com.chef.app.demo.DataRepository.Model.PickUpList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroWebServiceApi {
//    @GET("retrofit/json_object.json")
//    Call<PickUpListBean> getMyJSON();

    @GET("contacts/")
    Call<Example> getMyContacts();

    @GET("contacts/")
    Call<PickUpList> getPickUpList();

    @GET("contacts/")
    Call<DeliveryListBean> getDeliveryList();
}
