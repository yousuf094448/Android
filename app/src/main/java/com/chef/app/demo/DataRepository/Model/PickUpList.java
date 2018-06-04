package com.chef.app.demo.DataRepository.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PickUpList {
    @SerializedName("contacts")
    @Expose
    private List<PickUpItem> contacts = null;

    public List<PickUpItem>  getPickUpList() {
        return contacts;
    }

    public void setContacts(List<PickUpItem> contacts) {
        this.contacts = contacts;
    }
}
