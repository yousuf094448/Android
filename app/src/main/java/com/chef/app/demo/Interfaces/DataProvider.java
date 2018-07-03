package com.chef.app.demo.Interfaces;


import java.util.List;

public interface DataProvider {
    public DeliveryManProfile getDeliveryManProfile();
    public List<Delivery> getDeliveryList();
    public List<PickUp> getPickUpList();
    public List<Exchange> getExchangeList();
    public void completePickUp(String pickUpID, ResponseHandler resp);
    public void requestAllData(ResponseHandler resp);
    public void requestLogIn(ResponseHandler resp, String email, String password);
}
