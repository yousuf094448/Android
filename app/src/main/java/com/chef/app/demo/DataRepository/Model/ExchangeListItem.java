package com.chef.app.demo.DataRepository.Model;

import com.chef.app.demo.Interfaces.DeliveryManProfile;
import com.chef.app.demo.Interfaces.Exchange;
import com.chef.app.demo.Interfaces.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

public class ExchangeListItem implements Exchange{
    private DeliveryManProfile deliveryManProfile;
    private List<ExchangeItem> collectionItems;
    private List<ExchangeItem> handOverItems;

    ExchangeListItem(){
        deliveryManProfile = new DeliveryManProfile() {
            @Override
            public void logIn(ResponseHandler resp) {

            }

            @Override
            public String getName() {
                return "Delivery Man";
            }

            @Override
            public String getPhoneNumber() {
                return "01342583543";
            }

            @Override
            public String getAddress() {
                return "Unknown";
            }
        };

        ExchangeItem ex = new ExchangeItem() {
            @Override
            public String getChefName() {
                return "Chef Habib";
            }

            @Override
            public String getPacketCount() {
                return "2";
            }
        };

        collectionItems = new ArrayList<>();
        collectionItems.add(ex);
        collectionItems.add(ex);
        collectionItems.add(ex);

        handOverItems = new ArrayList<>();
        handOverItems.add(ex);
        handOverItems.add(ex);
        handOverItems.add(ex);
    }

    @Override
    public DeliveryManProfile getCoDeliveryManProfile() {
        return deliveryManProfile;
    }

    @Override
    public List<ExchangeItem> getColletionList() {
        return collectionItems;
    }

    @Override
    public List<ExchangeItem> getHandOverList() {
        return handOverItems;
    }
}
