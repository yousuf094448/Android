package com.chef.app.demo.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.chef.app.demo.AppManager;
import com.chef.app.demo.DataRepository.DataManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        AppManager.getInstance();// Initializing AppManager.
        DataManager.getInstance();
        Intent home = new Intent(this, HomeActivity.class);
        startActivity(home);
        finish();
    }
}
