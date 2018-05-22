package com.chef.app.demo.DataRepository.RetroWebServices;

import android.util.Log;

import com.chef.app.demo.DataRepository.RetroWebServices.Beans.Contact;
import com.chef.app.demo.DataRepository.RetroWebServices.Beans.DeliveryBean;
import com.chef.app.demo.DataRepository.RetroWebServices.Beans.DeliveryListBean;
import com.chef.app.demo.DataRepository.RetroWebServices.Beans.Example;
import com.chef.app.demo.DataRepository.RetroWebServices.Beans.PickUpBean;
import com.chef.app.demo.DataRepository.RetroWebServices.Beans.PickUpListBean;
import com.chef.app.demo.Interfaces.Delivery;
import com.chef.app.demo.Interfaces.DeliveryManProfile;
import com.chef.app.demo.Interfaces.PickUp;
import com.chef.app.demo.Interfaces.ResponseHandler;
import com.chef.app.demo.Interfaces.WebService;
import com.chef.app.demo.Model.PickUpInfo;
import com.chef.app.demo.Model.PickUpList;
import com.chef.app.demo.Model.ProfileInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroWebService implements WebService{

    private RetroWebServiceApi api;
    private List<Contact> contactList;
    private DeliveryManProfile mProfile;
    private List<PickUpBean> mPickUpList;
    private List<DeliveryBean> mDeliverList;

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

        Call<DeliveryListBean> call = api.getDeliveryList();
        call.enqueue(new Callback<DeliveryListBean>() {
            @Override
            public void onResponse(Call<DeliveryListBean> call, Response<DeliveryListBean> res) {
                if (res.isSuccessful()) {
                    mDeliverList = res.body().getDeliveryList();
                    response.onResponse(mDeliverList);
                }
            }

            @Override
            public void onFailure(Call<DeliveryListBean> call, Throwable t) {
                Log.d("APP", "onFailure: Retrieving PickUpList failed");
            }
        });
    }

    @Override
    public void requestPickUpInfo(final ResponseHandler response) {

        Call<PickUpListBean> call = api.getPickUpList();
        call.enqueue(new Callback<PickUpListBean>() {
            @Override
            public void onResponse(Call<PickUpListBean> call, Response<PickUpListBean> res) {
                if (res.isSuccessful()) {
                    mPickUpList = res.body().getPickUpList();
                    response.onResponse(mPickUpList);
                }
            }

            @Override
            public void onFailure(Call<PickUpListBean> call, Throwable t) {
                Log.d("APP", "onFailure: Retrieving PickUpList failed");
            }
        });

    }
}
