package com.chef.app.demo.View.Activities;

public class ExchangeItem {
    ExchangeItem(){
        name = "Chef Name";
        count = "2";
    }
    private String name, count;
    String getChefName(){
        return name;
    }
    String getPacketCount(){
        return count;
    }
}
