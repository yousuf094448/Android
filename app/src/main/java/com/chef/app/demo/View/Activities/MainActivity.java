package com.chef.app.demo.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;

import com.chef.app.demo.AppManager;
import com.chef.app.demo.Interfaces.DataProvider;
import com.chef.app.demo.Interfaces.ResponseHandler;
import com.chef.app.demo.R;
import com.github.ybq.android.spinkit.style.DoubleBounce;

public class MainActivity extends AppCompatActivity {

    private Intent homeIntent, logInIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

//        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
//        DoubleBounce doubleBounce = new DoubleBounce();
//        progressBar.setIndeterminateDrawable(doubleBounce);

        homeIntent = new Intent(this, HomeActivity.class);

        logInIntent = new Intent(this, LogInActivity.class);

        AppManager.getInstance();// Initializing AppManager.
        final DataProvider mData = AppManager.getInstance().getDataManager();

        if(AppManager.getInstance().isLoggedIn()){
            mData.requestLogIn(new ResponseHandler() {
                @Override
                public void onResponse(Object obj) {
                    mData.requestAllData(new ResponseHandler() {
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

                @Override
                public void onError(Error error) {

                }
            },"d@d.com", "123456");
        }else {
            startActivity(logInIntent);
            finish();
        }


    }
}
