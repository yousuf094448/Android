package com.chef.app.demo.View.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.chef.app.demo.View.DragAndDrop.DragAndDropAdapter;
import com.chef.app.demo.View.DragAndDrop.DragAndDropCallback;
import com.chef.app.demo.AppManager;
import com.chef.app.demo.Interfaces.PickUp;
import com.chef.app.demo.R;
import com.chef.app.demo.View.Adapters.PickUpRecyclerAdapter;

import java.util.List;

public class PickUpActivity extends AppCompatActivity {

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

        List<PickUp> input = AppManager.getInstance().getDataManager().getPickUpList();

        mAdapter = new PickUpRecyclerAdapter(input);
        pickUpRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.Callback callback =
                new DragAndDropCallback((DragAndDropAdapter) mAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(pickUpRecyclerView);
    }
}
