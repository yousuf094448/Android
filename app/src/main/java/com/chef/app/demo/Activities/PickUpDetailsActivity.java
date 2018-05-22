package com.chef.app.demo.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.chef.app.demo.AppManager;
import com.chef.app.demo.Interfaces.Delivery;
import com.chef.app.demo.Interfaces.PickUp;
import com.chef.app.demo.R;
import com.dd.processbutton.iml.ActionProcessButton;

public class PickUpDetailsActivity extends Activity implements ProgressGenerator.OnCompleteListener{

    private PickUp mPickUpItem;
    private TextView chefName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up_details);

        int item = getIntent().getIntExtra("SELECTED_ITEM",0);

        mPickUpItem = AppManager.getInstance().getDataManager().getPickUpList().get(item);
        chefName = findViewById(R.id.chef_name_pick_up_details);
        chefName.setText(mPickUpItem.getName());

//        final ProgressGenerator progressGenerator = new ProgressGenerator( this);
//        final ActionProcessButton btnSignIn =  findViewById(R.id.btnSignIn);
//            btnSignIn.setMode(ActionProcessButton.Mode.ENDLESS);
//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                progressGenerator.start(btnSignIn);
//                btnSignIn.setEnabled(false);
//            }
//        });
    }

    @Override
    public void onComplete() {

    }
}
