package com.chef.app.demo.Model;

import com.chef.app.demo.Interfaces.PickUp;

public class PickUpInfo implements PickUp {
    private String name,number,address;

    public PickUpInfo(String name, String number, String address){
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
