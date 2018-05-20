package com.chef.app.demo.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.chef.app.demo.R;
import com.dd.processbutton.iml.ActionProcessButton;

public class PickUpDetailsActivity extends Activity implements ProgressGenerator.OnCompleteListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up_details);
        final ProgressGenerator progressGenerator = new ProgressGenerator((ProgressGenerator.OnCompleteListener) this);
        final ActionProcessButton btnSignIn = (ActionProcessButton) findViewById(R.id.btnSignIn);
            btnSignIn.setMode(ActionProcessButton.Mode.ENDLESS);
//            btnSignIn.setMode(ActionProcessButton.Mode.PROGRESS);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressGenerator.start(btnSignIn);
                btnSignIn.setEnabled(false);
            }
        });
    }

    @Override
    public void onComplete() {

    }
}
