package com.chef.app.demo.Interfaces;

import java.util.List;

public interface Exchange {
    DeliveryManProfile getCoDeliveryManProfile();
    List<ExchangeItem> getColletionList();
    List<ExchangeItem> getHandOverList();

    public interface ExchangeItem{
        String getChefName();
        String getPacketCount();
    }
}
