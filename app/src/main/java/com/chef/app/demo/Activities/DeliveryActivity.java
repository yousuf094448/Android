package com.chef.app.demo.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chef.app.demo.AppManager;
import com.chef.app.demo.DataRepository.DataManager;
import com.chef.app.demo.Interfaces.Delivery;
import com.chef.app.demo.R;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends Activity {

    private RecyclerView deliveryRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        deliveryRecyclerView = findViewById(R.id.delivery_recycler_view);

        deliveryRecyclerView.setHasFixedSize(false);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        deliveryRecyclerView.setLayoutManager(layoutManager);
        List<Delivery> input = AppManager.getInstance().getDataManager().getDeliveryList();

        mAdapter = new DeliveryRecyclerAdapter(input);
        deliveryRecyclerView.setAdapter(mAdapter);

    }
}

