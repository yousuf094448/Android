package com.chef.app.demo.View.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.chef.app.demo.View.Adapters.ExchangePacketsListAdapter;

import com.chef.app.demo.R;

import java.util.ArrayList;
import java.util.List;

public class ExchangeDetailsActivity extends AppCompatActivity {

    private ExchangePacketsListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_details);

        ListView collectionList = findViewById(R.id.collection_list);

        List<ExchangeItem> exItems = new ArrayList<>();
        exItems.add(new ExchangeItem());
        exItems.add(new ExchangeItem());
        mAdapter = new ExchangePacketsListAdapter(this, R.layout.exchange_packets_list_item, exItems);
        collectionList.setAdapter(mAdapter);

        ListView handOverList = findViewById(R.id.handover_list);
        handOverList.setAdapter(mAdapter);
    }
}
