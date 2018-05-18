package com.chef.app.demo.DataRepository.WebServices;

import com.chef.app.demo.DataRepository.Beans.PickUpListBean;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {
    @GET("retrofit/json_object.json")
    Call<PickUpListBean> getMyJSON();
}
