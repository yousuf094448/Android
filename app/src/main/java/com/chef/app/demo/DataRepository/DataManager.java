package com.chef.app.demo.DataRepository;

import android.util.Log;

import com.chef.app.demo.AppManager;
import com.chef.app.demo.DataRepository.Beans.PickUpBean;
import com.chef.app.demo.DataRepository.Beans.PickUpListBean;
import com.chef.app.demo.DataRepository.Helper.RetroClient;
import com.chef.app.demo.DataRepository.WebServices.WebService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataManager {

    private static DataManager obj = null;
    private WebService api;
    private List<PickUpBean> pickUpList;

    public DataManager(){
        api = RetroClient.getApiService();

        Call<PickUpListBean> call = api.getMyJSON();
        call.enqueue(new Callback<PickUpListBean>() {
            @Override
            public void onResponse(Call<PickUpListBean> call, Response<PickUpListBean> response) {
                if (response.isSuccessful()) {
                    pickUpList = response.body().getEmployee();
                }
            }

            @Override
            public void onFailure(Call<PickUpListBean> call, Throwable t) {
                Log.d("APP", "onFailure: Retrieving PickUpList failed");
            }
        });
    }

    public static DataManager getInstance(){
        if(obj == null) obj = new DataManager();
        return  obj;
    }
    public List<PickUpBean> getPickUpList(){
        return pickUpList;
    }
}
