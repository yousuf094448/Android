package com.chef.app.demo.Model;

import com.chef.app.demo.Interfaces.DeliveryManProfile;

public class ProfileInfo implements DeliveryManProfile{
    private String name,number,address;

    public ProfileInfo(String name, String number, String address){
        this.name = name;
        this.number = number;
        this.address = address;
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
