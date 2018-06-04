package com.chef.app.demo.DataRepository.Model;

import com.chef.app.demo.Interfaces.DeliveryManProfile;
import com.chef.app.demo.Interfaces.ResponseHandler;

public class ProfileInfo implements DeliveryManProfile{
    private String name,number,address;

    public ProfileInfo(String name, String number, String address){
        this.name = name;
        this.number = number;
        this.address = address;
    }

    @Override
    public void logIn(ResponseHandler resp) {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPhoneNumber() {
        return number;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
