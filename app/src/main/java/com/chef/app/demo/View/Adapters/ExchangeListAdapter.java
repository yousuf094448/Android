package com.chef.app.demo.View.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.chef.app.demo.DataRepository.Model.ExchangeListItem;

import java.util.ArrayList;
import java.util.List;

public class ExchangeListAdapter extends ArrayAdapter<ExchangeListItem> {

    private int resoource;
    private Context mContext;
    private List<ExchangeListItem> exchangeListItems = new ArrayList<>();

    public ExchangeListAdapter(@NonNull Context context, int resource, List<ExchangeListItem> exchangeListItems) {
        super(context, resource, exchangeListItems);
        this.resoource = resource;

        this.exchangeListItems = exchangeListItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        View listItem = convertView;
//        if(listItem == null)
//            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
//
//        ExchangeListItem currentItem = exchangeListItems.get(position);
//
//        TextView tvLeft = (TextView) listItem.findViewById(R.id.textView_name);
//        tvLeft.setText(currentItem.getColletionList());
//
//        TextView release = (TextView) listItem.findViewById(R.id.textView_release);
//        release.setText(currentMovie.getmRelease());

//        return listItem;
        return null;
    }
}
