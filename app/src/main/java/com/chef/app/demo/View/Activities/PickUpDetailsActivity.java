package com.chef.app.demo.View.Activities;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.drm.DrmStore;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.chef.app.demo.AppManager;
import com.chef.app.demo.DialogUtil;
import com.chef.app.demo.Interfaces.PickUp;
import com.chef.app.demo.Interfaces.ResponseHandler;
import com.chef.app.demo.R;
import com.chef.app.demo.View.Adapters.ProgressGenerator;
import com.dd.processbutton.iml.ActionProcessButton;

public class PickUpDetailsActivity extends AppCompatActivity implements ProgressGenerator.OnCompleteListener {

    private PickUp mPickUpItem;
    private TextView chefName;
    private ActionProcessButton btnComplete;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up_details);
        context = this;

        int item = getIntent().getIntExtra("SELECTED_ITEM",0);

        mPickUpItem = AppManager.getInstance().getDataManager().getPickUpList().get(item);
        chefName = findViewById(R.id.chef_name_pick_up_details);
        chefName.setText(mPickUpItem.getName());

        btnComplete = findViewById(R.id.btn_pick_up_complete);
        btnComplete.setMode(ActionProcessButton.Mode.ENDLESS);
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.completePickUpDialog(PickUpDetailsActivity.this, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btnComplete.setEnabled(false);
                        btnComplete.setProgress(1);
                        AppManager.getInstance().getDataManager().completePickUp("test", new ResponseHandler() {
                            @Override
                            public void onResponse(Object obj) {
                                btnComplete.setProgress(100);
//                                btnComplete.setBackgroundColor(Color.DKGRAY);
                            }

                            @Override
                            public void onError(Exception error) {
                                btnComplete.setEnabled(true);
                            }
                        });
                    }
                }).show();

            }
        });
    }

    @Override
    public void onComplete() {

    }
}
