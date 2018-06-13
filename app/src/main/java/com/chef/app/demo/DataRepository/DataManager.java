package com.chef.app.demo.DataRepository;

import android.util.Log;

import com.chef.app.demo.Interfaces.DataProvider;
import com.chef.app.demo.Interfaces.Delivery;
import com.chef.app.demo.Interfaces.DeliveryManProfile;
import com.chef.app.demo.Interfaces.PickUp;
import com.chef.app.demo.Interfaces.ResponseHandler;
import com.chef.app.demo.Interfaces.WebService;
import com.chef.app.demo.DataRepository.RetroWebServices.RetroWebService;

import java.util.List;


public class DataManager implements DataProvider{

    private static DataManager obj = null;
    private DeliveryManProfile deliveryMan;
    private List<Delivery> mDeliVeryList;
    private List<PickUp> mPickUpList;
    private WebService mWebService;
    private DataProvider mDataProvider;

    public static DataManager getInstance(){
        if(obj == null) obj = new DataManager(new RetroWebService());
        return  obj;
    }

    private DataManager(final WebService mWebService){
        this.mWebService = mWebService;
    }

    @Override
    public DeliveryManProfile getDeliveryManProfile() {
        return deliveryMan;
    }

    @Override
    public List<Delivery> getDeliveryList() {
        return mDeliVeryList;
    }

    @Override
    public List<PickUp> getPickUpList(){
        return mPickUpList;
    }

    @Override
    public void requestAllData(final ResponseHandler resp) {
        mWebService.requestProfile(new ResponseHandler() {
            @Override
            public void onResponse(Object obj) {
                deliveryMan = (DeliveryManProfile) obj;
                mWebService.requestPickUpInfo(new ResponseHandler() {
                    @Override
                    public void onResponse(Object obj) {
                        mPickUpList = (List<PickUp>) obj;
                        mWebService.requestDeliveryInfo(new ResponseHandler() {
                            @Override
                            public void onResponse(Object obj) {
                                mDeliVeryList = (List<Delivery>) obj;
                                resp.onResponse(obj);
                            }

                            @Override
                            public void onError(Error error) {

                            }
                        });
                    }

                    @Override
                    public void onError(Error error) {

                    }
                });
            }

            @Override
            public void onError(Error error) {

            }
        });
    }

    @Override
    public void requestLogIn(final ResponseHandler resp, String email, String password) {
        mWebService.requestLogIn(new ResponseHandler() {
            @Override
            public void onResponse(Object obj) {
                Log.d("LOGIN", "onResponse: log in response 1");
                resp.onResponse(null);
            }

            @Override
            public void onError(Error error) {

            }
        }, email, password);
    }
}
