package com.chef.app.demo.DataRepository.RetroWebServices.Beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PickUpListBean {
    @SerializedName("contacts")
    @Expose
    private List<PickUpBean> contacts = null;

    public List<PickUpBean>  getPickUpList() {
        return contacts;
    }

    public void setContacts(List<PickUpBean> contacts) {
        this.contacts = contacts;
    }
}
