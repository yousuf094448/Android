package com.chef.app.demo.View.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;

import com.chef.app.demo.AppManager;
import com.chef.app.demo.AppNetworkManager;
import com.chef.app.demo.DialogUtil;
import com.chef.app.demo.Interfaces.DataProvider;
import com.chef.app.demo.Interfaces.ResponseHandler;
import com.chef.app.demo.R;
import com.github.ybq.android.spinkit.style.DoubleBounce;

public class MainActivity extends AppCompatActivity {

    private Intent homeIntent, logInIntent;
    final DataProvider mData = AppManager.getInstance().getDataManager();
    final AppNetworkManager netManager = AppManager.getInstance().getNetManager();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        homeIntent = new Intent(this, HomeActivity.class);
        logInIntent = new Intent(this, LogInActivity.class);

        AppManager.getInstance();// Initializing AppManager.
        context = this;

    }

    @Override
    protected void onResume() {
        super.onResume();

        if(netManager.isInternetConnected(this)){
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
                            public void onError(Exception ex) {
                                Log.d("APIError", "onResponse: main "+ex.getMessage());
                                DialogUtil.exceptionAlert(context, ex.getMessage(), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        finish();
                                    }
                                }).show();
                            }
                        });
                    }

                    @Override
                    public void onError(Exception ex) {

                    }
                },"d@d.com", "123456");
            }else {
                startActivity(logInIntent);
                finish();
            }
        }else {
            DialogUtil.netWorkErrorAlert(this, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            }).show();
        }


    }
}
