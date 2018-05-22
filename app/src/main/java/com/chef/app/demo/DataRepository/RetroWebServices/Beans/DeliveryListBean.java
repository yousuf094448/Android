package com.chef.app.demo.DataRepository.RetroWebServices.Beans;

import com.chef.app.demo.Interfaces.Delivery;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeliveryListBean {
    @SerializedName("contacts")
    @Expose
    private List<DeliveryBean> contacts = null;

    public List<DeliveryBean>  getDeliveryList() {
        return contacts;
    }

    public void setContacts(List<DeliveryBean> contacts) {
        this.contacts = contacts;
    }
}
