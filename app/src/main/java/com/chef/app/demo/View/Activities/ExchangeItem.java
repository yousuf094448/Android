package com.chef.app.demo.View.Activities;

public class ExchangeItem {
    public ExchangeItem(){
        name = "Chef Name";
        count = "2";
    }
    private String name, count;
    public String getChefName(){
        return name;
    }
    public String getPacketCount(){
        return count;
    }
}
