package com.chef.app.demo.DataRepository;

import com.chef.app.demo.DataRepository.Model.PickUpItem;
import com.chef.app.demo.DataRepository.Model.ProfileInfo;
import com.chef.app.demo.DataRepository.RetroWebServices.RetroWebService;
import com.chef.app.demo.Interfaces.DataProvider;
import com.chef.app.demo.Interfaces.Delivery;
import com.chef.app.demo.Interfaces.DeliveryManProfile;
import com.chef.app.demo.Interfaces.PickUp;
import com.chef.app.demo.Interfaces.ResponseHandler;
import com.chef.app.demo.Interfaces.WebService;

import java.util.ArrayList;
import java.util.List;

public class TestDataProvider implements DataProvider{

    private static TestDataProvider obj = null;
    private DeliveryManProfile deliveryMan;
    private List<Delivery> mDeliVeryList;
    private List<PickUp> mPickUpList;
    private WebService mWebService;
    private DataProvider mDataProvider;

    public static TestDataProvider getInstance(){
        if(obj == null) obj = new TestDataProvider(new RetroWebService());
        return  obj;
    }

    private TestDataProvider(final WebService mWebService){
        this.mWebService = mWebService;

        //DeliveryManProfile
        deliveryMan = new ProfileInfo("DeliveryMan Name", "01648264873","Unknown");

        //PickUpList
        PickUp pickUp = new PickUp() {
            @Override
            public String getName() {
                return "Chef Name";
            }

            @Override
            public String getPhoneNumber() {
                return "01475635763";
            }

            @Override
            public String getAddress() {
                return "East Monipur, Shewrapara";
            }

            @Override
            public String getPickUpStatus() {
                return "Pending";
            }

            @Override
            public String getNumberOfPackets() {
                return "5";
            }
        };
        mPickUpList = new ArrayList<>();
        for(int i = 0; i<7; i++) mPickUpList.add(pickUp);

        //Delivery List
        Delivery delivery = new Delivery() {
            @Override
            public String getName() {
                return "DeliveryMan Name";
            }

            @Override
            public String getPhoneNumber() {
                return "017462548375";
            }

            @Override
            public String getAddress() {
                return "Unknown";
            }
        };
        mDeliVeryList = new ArrayList<>();
        for(int i = 0; i<7; i++) mDeliVeryList.add(delivery);

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
    public List<PickUp> getPickUpList() {
        return mPickUpList;
    }

    @Override
    public void requestAllData(ResponseHandler resp) {

        resp.onResponse(obj);
    }

    @Override
    public void requestLogIn(ResponseHandler resp, String email, String password) {

        mWebService.requestLogIn(resp,email,password);
    }
}
