package com.chef.app.demo.View.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.drm.DrmStore;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.chef.app.demo.DialogUtil;
import com.chef.app.demo.R;
import com.dd.processbutton.iml.ActionProcessButton;

public class DeliveryDetailsActivity extends AppCompatActivity {

    Context mContext;
    ActionProcessButton btnComplete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);

        btnComplete = findViewById(R.id.delivery_complete_btn);

        mContext = this;
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.completeDeliveryDialog(mContext, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
            }
        });
    }
}
