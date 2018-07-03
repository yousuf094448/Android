package com.chef.app.demo.View.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.chef.app.demo.AppManager;
import com.chef.app.demo.Interfaces.ResponseHandler;
import com.chef.app.demo.R;
import com.dd.processbutton.iml.ActionProcessButton;

public class LogInActivity extends AppCompatActivity {

    private ActionProcessButton btnSignIn;
    private Intent homeIntent;
    private EditText etEmail, etPassword;
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_log_in);

        etEmail = findViewById(R.id.login_email);
        etPassword = findViewById(R.id.login_password);

        //test authentication
        etEmail.setText("d@d.com");
        etPassword.setText("123456");
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();

        homeIntent = new Intent(this, HomeActivity.class);

        btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSignIn.setEnabled(false);
                btnSignIn.setMode(ActionProcessButton.Mode.ENDLESS);
                btnSignIn.setProgress(1);
                AppManager.getInstance().getDataManager().requestLogIn(new ResponseHandler() {
                    @Override
                    public void onResponse(Object obj) {
                        startActivity(homeIntent);
                        finish();
                    }

                    @Override
                    public void onError(Exception ex) {
                        Toast.makeText(LogInActivity.this, "Log In Failed", Toast.LENGTH_LONG).show();

                    }
                },email,password);
            }
        });
    }
}
