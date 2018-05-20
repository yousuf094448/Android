package com.chef.app.demo.Model;

import android.widget.LinearLayout;

import com.chef.app.demo.Interfaces.PickUp;

import java.util.List;

public class PickUpList {
    private List<PickUp> mPickUpList;

    public List<PickUp> getContacts() {
        return mPickUpList;
    }

    public void setContacts(List<PickUp> pickUpList) {
        this.mPickUpList = pickUpList;
    }
}
