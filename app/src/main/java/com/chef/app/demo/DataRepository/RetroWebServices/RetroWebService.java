package com.chef.app.demo.DataRepository.RetroWebServices;

import android.util.Log;
import android.widget.Toast;

import com.chef.app.demo.DataRepository.LogIn.LogIn;
import com.chef.app.demo.DataRepository.Model.Contact;
import com.chef.app.demo.DataRepository.Model.Example;
import com.chef.app.demo.DataRepository.RetroWebServices.Delivery.RetroDeliveryListItem;
import com.chef.app.demo.DataRepository.RetroWebServices.Delivery.RetroDelivery;
import com.chef.app.demo.DataRepository.RetroWebServices.Error.APIError;
import com.chef.app.demo.DataRepository.RetroWebServices.PickUp.RetroPickUpListItem;
import com.chef.app.demo.DataRepository.RetroWebServices.PickUp.RetroPickUp;
import com.chef.app.demo.DataRepository.Model.ProfileInfo;
import com.chef.app.demo.Interfaces.DeliveryManProfile;
import com.chef.app.demo.Interfaces.ResponseHandler;
import com.chef.app.demo.Interfaces.WebService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroWebService implements WebService{

    private RetroWebServiceApi api;
    private List<Contact> contactList;
    private DeliveryManProfile mProfile;
    private List<RetroPickUpListItem> mPickUpList;
    private List<RetroDeliveryListItem> mDeliverList;
    private DeliveryManProfile profile;

    public RetroWebService(){
        api = RetroClient.getApiService();
        mPickUpList = new ArrayList<>();
        mDeliverList = new ArrayList<>();
    }

    @Override
    public void requestAllData(ResponseHandler response) {
        this.requestProfile(response);
    }

    @Override
    public void requestProfile(final ResponseHandler response) {
        Call<Example> call = api.getMyContacts();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> res) {
                if (res.isSuccessful()) {
                    contactList = res.body().getContacts();
                    Contact contact = contactList.get(0);
                    mProfile = new ProfileInfo(contact.getName(),contact.getPhone().getMobile(),contact.getAddress());
                    response.onResponse(mProfile);
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("APP", "onFailure: Retrieving PickUpList failed");
            }
        });
    }

    @Override
    public void requestDeliveryInfo(final ResponseHandler response) {

        Call<RetroDelivery> call = api.getDeliveryList("http://cookantsapplicationdev-env-1.us-east-1.elasticbeanstalk.com/api/Delivery/GetDeliveryListByDeliveryMan/5/2018-06-14/1");
        call.enqueue(new Callback<RetroDelivery>() {
            @Override
            public void onResponse(Call<RetroDelivery> call, Response<RetroDelivery> res) {
                if (res.isSuccessful()) {
                    mDeliverList = res.body().getData();
                    response.onResponse(mDeliverList);
                }
            }

            @Override
            public void onFailure(Call<RetroDelivery> call, Throwable t) {
                Log.d("APP", "onFailure: Retrieving PickUpList failed");
            }
        });
    }

    @Override
    public void requestPickUpInfo(final ResponseHandler response) {

//        Call<RetroPickUp> call = api.getPickUpList("5","2018-06-14", "1");
        Call<RetroPickUp> call = api.getPickUpList2("http://cookantsapplicationdev-env-1.us-east-1.elasticbeanstalk.com/api/Delivery/GetPickUpListByDeliveryMan/5/2018-06-14/1");
        call.enqueue(new Callback<RetroPickUp>() {
            @Override
            public void onResponse(Call<RetroPickUp> call, Response<RetroPickUp> res) {
                Log.d("PICKUPTEST", "onResponse: resp = "+res.isSuccessful());
                Log.d("PICKUPTEST", "onResponse: resp = "+res.message());
//                Log.d("PICKUPTEST", "onResponse: resp = "+res.body().getStatus());
                if (res.isSuccessful()) {
                    mPickUpList = res.body().getData();
                    response.onResponse(mPickUpList);
                }else{
                    Log.d("APIError", "onResponse: "+res.message());
                    response.onError(new Exception(res.message()));
                }
            }

            @Override
            public void onFailure(Call<RetroPickUp> call, Throwable t) {
                Log.d("APP", "onFailure: Retrieving PickUpList failed");
            }
        });

    }

    @Override
    public void requestLogIn(final ResponseHandler resp, String email, String password) {
        Call<LogIn> call = api.logIn(email,password);
        call.enqueue(new Callback<LogIn>() {
            @Override
            public void onResponse(Call<LogIn> call, Response<LogIn> response) {
                Log.d("LOGIN", "onResponse: Log in successful");
                if(response.isSuccessful()){
                    profile = response.body().getProfile();
                    resp.onResponse(profile);
                }
            }

            @Override
            public void onFailure(Call<LogIn> call, Throwable t) {
                Log.d("LOGIN", "onResponse: Log in Failed");
            }
        });
    }
}
