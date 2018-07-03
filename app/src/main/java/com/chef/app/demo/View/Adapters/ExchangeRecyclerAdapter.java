package com.chef.app.demo.View.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.chef.app.demo.Interfaces.Exchange;
import com.chef.app.demo.R;
import com.chef.app.demo.View.DragAndDrop.DragAndDropAdapter;
import com.chef.app.demo.View.DragAndDrop.DragAndDropViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRecyclerAdapter extends RecyclerView.Adapter<ExchangeRecyclerAdapter.ViewHolder> implements DragAndDropAdapter {

    private int resoource;
    private Context mContext;
    private List<Exchange> exchangeList;
    ExchangePacketsListAdapter collectAdapter, handOverAdapter;

    ListView handOverList, collectionList;

    public class ViewHolder extends RecyclerView.ViewHolder implements DragAndDropViewHolder {

        public View layout;

        ViewHolder(View v) {
            super(v);
            layout = v.findViewById(R.id.exchange_row);
            mContext = v.getContext();
        }

        @Override
        public void onItemSelected() {

        }

        @Override
        public void onItemClear() {

        }
    }

    public ExchangeRecyclerAdapter(List<Exchange> exchangeList){
        this.exchangeList = exchangeList;
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {

    }

    @Override
    public void onItemDismiss(int position) {

    }

    @NonNull
    @Override
    public ExchangeRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.exchnage_list_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        collectAdapter = new ExchangePacketsListAdapter(mContext, R.layout.exchange_packets_list_item, exchangeList.get(position).getColletionList());
        handOverAdapter = new ExchangePacketsListAdapter(mContext, R.layout.exchange_packets_list_item, exchangeList.get(position).getHandOverList());

//        LinearLayout ll = holder.layout.findViewById(R.id.exchange_row);
//        ll.setlay

        collectionList = holder.layout.findViewById(R.id.collection_list);
        collectionList.setAdapter(collectAdapter);

        handOverList = holder.layout.findViewById(R.id.handover_list);
        handOverList.setAdapter(handOverAdapter);

        ViewGroup.LayoutParams header = holder.layout.findViewById(R.id.exchange_item_header).getLayoutParams();
        Log.d("LISTVIEW", "onBindViewHolder: header height = "+header.height);

        ViewGroup.LayoutParams collection = holder.layout.findViewById(R.id.ll_collection_ist).getLayoutParams();
        Log.d("LISTVIEW", "onBindViewHolder: header height = "+collection.height);

        int size = exchangeList.get(position).getColletionList().size();
        if(size<exchangeList.get(position).getHandOverList().size()) size = exchangeList.get(position).getHandOverList().size();
        ViewGroup.LayoutParams ll = holder.layout.getLayoutParams();
        ll.height = (header.height*2)+(30*size);
        holder.layout.setLayoutParams(ll);
    }

    @Override
    public int getItemCount() {
        return exchangeList.size();
    }
}
