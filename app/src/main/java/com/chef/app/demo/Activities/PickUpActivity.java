package com.chef.app.demo.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chef.app.demo.AppManager;
import com.chef.app.demo.DataRepository.Beans.PickUpBean;
import com.chef.app.demo.DataRepository.DataManager;
import com.chef.app.demo.R;

import java.util.List;

public class PickUpActivity extends Activity {

    private RecyclerView pickUpRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up);
        pickUpRecyclerView = findViewById(R.id.pick_up_recycler_view);

        pickUpRecyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(this);
        pickUpRecyclerView.setLayoutManager(layoutManager);

//        List<String> input = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            input.add("Test" + i);
//        }

        List<PickUpBean> input = DataManager.getInstance().getPickUpList();

        mAdapter = new PickUpRecyclerAdapter(input);
        pickUpRecyclerView.setAdapter(mAdapter);
    }
}
