package com.chef.app.demo.DataRepository;

import com.chef.app.demo.DataRepository.Model.PickUpItem;
import com.chef.app.demo.DataRepository.Model.ProfileInfo;
import com.chef.app.demo.DataRepository.RetroWebServices.RetroWebService;
import com.chef.app.demo.Interfaces.DataProvider;
import com.chef.app.demo.Interfaces.Delivery;
import com.chef.app.demo.Interfaces.DeliveryManProfile;
import com.chef.app.demo.Interfaces.Exchange;
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
    private List<Exchange> mExchangeList;
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

            @Override
            public String getDeliverySttus() {
                return "Pending";
            }

            @Override
            public String getDeliveryCount() {
                return "3";
            }
        };
        mDeliVeryList = new ArrayList<>();
        for(int i = 0; i<7; i++) mDeliVeryList.add(delivery);


        //ExchangeList
        Exchange exchange = new Exchange() {
            @Override
            public DeliveryManProfile getCoDeliveryManProfile() {
                return null;
            }

            @Override
            public List<ExchangeItem> getColletionList() {
                ExchangeItem ei = new ExchangeItem() {
                    @Override
                    public String getChefName() {
                        return "Test 1";
                    }

                    @Override
                    public String getPacketCount() {
                        return "2";
                    }
                };

                List<ExchangeItem> eil = new ArrayList<>();
                for(int i = 0; i<5; i++) eil.add(ei);
                return eil;
            }

            @Override
            public List<ExchangeItem> getHandOverList() {
                ExchangeItem ei = new ExchangeItem() {
                    @Override
                    public String getChefName() {
                        return "Test 1";
                    }

                    @Override
                    public String getPacketCount() {
                        return "2";
                    }
                };

                List<ExchangeItem> eil = new ArrayList<>();
                for(int i = 0; i<5; i++) eil.add(ei);
                return eil;
            }
        };
        mExchangeList = new ArrayList<>();
        for(int i = 0; i<7; i++) mExchangeList.add(exchange);

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
    public List<Exchange> getExchangeList() {
        return mExchangeList;
    }

    @Override
    public void requestAllData(final ResponseHandler resp) {

//        mWebService.requestPickUpInfo(new ResponseHandler() {
//            @Override
//            public void onResponse(Object obj) {
//                mPickUpList = (List<PickUp>) obj;
//                resp.onResponse(obj);
//            }
//
//            @Override
//            public void onError(Error error) {
//
//            }
//        });
    }

    @Override
    public void requestLogIn(final ResponseHandler resp, String email, String password) {

        mWebService.requestLogIn(new ResponseHandler() {
            @Override
            public void onResponse(Object obj) {
                deliveryMan = (DeliveryManProfile) obj;
                resp.onResponse(obj);
            }

            @Override
            public void onError(Error error) {

            }
        }, email, password);
    }
}
