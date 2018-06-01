package com.chef.app.demo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.chef.app.demo.R;
import com.dd.processbutton.iml.ActionProcessButton;

public class LogInActivity extends AppCompatActivity {

    private ActionProcessButton btnSugnIn;
    private Intent homeIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_log_in);

        homeIntent = new Intent(this, HomeActivity.class);

        btnSugnIn = findViewById(R.id.btn_sign_in);
        btnSugnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeIntent);
                finish();
            }
        });
    }
}
