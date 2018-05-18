package com.chef.app.demo;

import android.util.Log;

import com.chef.app.demo.DataRepository.WebServices.WebService;
import com.chef.app.demo.DataRepository.Beans.PickUpBean;
import java.util.List;

public class AppManager {

    private static AppManager obj = null;
    private WebService api;
    private List<PickUpBean> pickUpList;

    private AppManager(){
        Log.d("APP", "AppManager: Initialization");

    }
    public static AppManager getInstance(){
        if(obj == null) obj = new AppManager();
        return  obj;
    }

}
