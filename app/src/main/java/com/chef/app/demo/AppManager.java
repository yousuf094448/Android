package com.chef.app.demo;

import android.util.Log;

import com.chef.app.demo.DataRepository.DataManager;
import com.chef.app.demo.DataRepository.RetroWebServices.Beans.Example;
import com.chef.app.demo.DataRepository.RetroWebServices.RetroClient;
import com.chef.app.demo.DataRepository.RetroWebServices.RetroWebService;
import com.chef.app.demo.DataRepository.RetroWebServices.RetroWebServiceApi;
import com.chef.app.demo.DataRepository.RetroWebServices.Beans.PickUpBean;
import com.chef.app.demo.Interfaces.DataProvider;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppManager {

    private static AppManager obj = null;
    private static DataProvider dataManager;
    private RetroWebServiceApi api;
    private List<PickUpBean> pickUpList;

    private AppManager(){
        Log.d("APP", "AppManager: Initialization");
        dataManager = new DataManager(new RetroWebService());
    }
    public static AppManager getInstance(){
        if(obj == null) obj = new AppManager();
        return  obj;
    }

    public  DataProvider getDataManager(){
        return dataManager;
    }

}
