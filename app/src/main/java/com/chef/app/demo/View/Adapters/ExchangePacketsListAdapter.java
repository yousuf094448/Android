package com.chef.app.demo.View.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import com.chef.app.demo.R;
import com.chef.app.demo.View.Activities.ExchangeItem;

import java.util.ArrayList;
import java.util.List;

public class ExchangePacketsListAdapter extends ArrayAdapter<ExchangeItem> {

    private int resoource;
    private Context mContext;
    private List<ExchangeItem> exchangeListItems = new ArrayList<>();
    public ExchangePacketsListAdapter(@NonNull Context context, int resource, List<ExchangeItem> exchangeListItems) {
        super(context, resource, exchangeListItems);
        this.resoource = resource;
        mContext = context;
        this.exchangeListItems = exchangeListItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.exchange_packets_list_item,parent,false);

//        ExchangeListItem currentItem = exchangeListItems.get(position);

        TextView tvLeft = (TextView) listItem.findViewById(R.id.collection_chef_name);
        tvLeft.setText("Chef Habiba");

        TextView rvRight = (TextView) listItem.findViewById(R.id.collection_packet_count);
        rvRight.setText("4");

        return listItem;
    }
}