package com.chef.app.demo.Interfaces;

import com.chef.app.demo.Model.PickUpInfo;

import java.util.List;

public interface DataProvider {
    public DeliveryManProfile getUserProfile();
    public List<Delivery> getDeliveryList();
    public List<PickUp> getPickUpList();
    public void RequestAllData(ResponseHandler resp);
}
