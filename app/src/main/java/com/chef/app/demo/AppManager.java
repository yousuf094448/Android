package com.chef.app.demo;

import android.util.Log;

import com.chef.app.demo.DataRepository.DataManager;
import com.chef.app.demo.DataRepository.RetroWebServices.RetroWebService;
import com.chef.app.demo.DataRepository.RetroWebServices.RetroWebServiceApi;
import com.chef.app.demo.DataRepository.Model.PickUpItem;
import com.chef.app.demo.DataRepository.TestDataProvider;
import com.chef.app.demo.Interfaces.DataProvider;

import java.util.List;

public class AppManager {

    private static AppManager obj = null;
    private static DataProvider dataManager;
    private RetroWebServiceApi api;
    private List<PickUpItem> pickUpList;
    private boolean isLoggedIn = true;
    private AppNetworkManager netManager;

    public static AppManager getInstance(){
        if(obj == null) obj = new AppManager();
        return  obj;
    }

    private AppManager(){
        Log.d("APP", "AppManager: Initialization");
//        dataManager = DataManager.getInstance();
        dataManager = TestDataProvider.getInstance();
        netManager = new AppNetworkManager();

    }


    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public  DataProvider getDataManager(){
        return dataManager;
    }

    public AppNetworkManager getNetManager() {
        return netManager;
    }
}
