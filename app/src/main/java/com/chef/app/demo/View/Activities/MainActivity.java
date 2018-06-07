package com.chef.app.demo.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chef.app.demo.AppManager;
import com.chef.app.demo.Interfaces.DataProvider;
import com.chef.app.demo.Interfaces.ResponseHandler;
import com.chef.app.demo.R;

public class MainActivity extends AppCompatActivity {

    private Intent homeIntent, logInIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        homeIntent = new Intent(this, HomeActivity.class);

        logInIntent = new Intent(this, LogInActivity.class);

        AppManager.getInstance();// Initializing AppManager.
        DataProvider mData = AppManager.getInstance().getDataManager();

        mData.RequestAllData(new ResponseHandler() {
            @Override
            public void onResponse(Object obj) {
                startActivity(homeIntent);
                finish();
            }

            @Override
            public void onError(Error error) {

            }
        });

    }
}
