package com.chef.app.demo.Activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

import com.chef.app.demo.R;

public class HistoryActivity extends AppCompatActivity {

    CalendarView c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        c = findViewById(R.id.calendarView);

        setContentView(R.layout.activity_history);
    }
}
