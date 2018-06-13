package com.chef.app.demo.Interfaces;

public interface WebService {
    public void requestAllData(ResponseHandler response);
    public void requestProfile(ResponseHandler response);
    public void requestDeliveryInfo(ResponseHandler response);
    public void requestPickUpInfo(ResponseHandler response);
    public void requestLogIn(ResponseHandler resp, String email, String password);
}
