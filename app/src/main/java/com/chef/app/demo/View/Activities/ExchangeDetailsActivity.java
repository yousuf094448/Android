package com.chef.app.demo.View.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.chef.app.demo.AppManager;
import com.chef.app.demo.Interfaces.Exchange;
import com.chef.app.demo.View.Adapters.ExchangePacketsListAdapter;

import com.chef.app.demo.R;
import com.chef.app.demo.View.Adapters.ExchangeRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ExchangeDetailsActivity extends AppCompatActivity {

    private ExchangePacketsListAdapter mAdapter;
    private List<Exchange> exchangeList;

    private RecyclerView exchangeRecyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        exchangeList = AppManager.getInstance().getDataManager().getExchangeList();

        if(exchangeList == null || exchangeList.size() == 0){
            setContentView(R.layout.error_layout);
            return;
        }

        setContentView(R.layout.activity_exchange_details);
        exchangeRecyclerView = findViewById(R.id.exchange_recycler_view);

        exchangeRecyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(this);
        exchangeRecyclerView.setLayoutManager(layoutManager);
        List<Exchange> input = AppManager.getInstance().getDataManager().getExchangeList();
        recyclerAdapter = new ExchangeRecyclerAdapter(input);
        exchangeRecyclerView.setAdapter(recyclerAdapter);

//        ListView collectionList = findViewById(R.id.collection_list);
//
//        List<ExchangeItem> exItems = new ArrayList<>();
//        exItems.add(new ExchangeItem());
//        exItems.add(new ExchangeItem());
//        mAdapter = new ExchangePacketsListAdapter(this, R.layout.exchange_packets_list_item, exItems);
//        collectionList.setAdapter(mAdapter);
//
//        ListView handOverList = findViewById(R.id.handover_list);
//        handOverList.setAdapter(mAdapter);
    }
}
