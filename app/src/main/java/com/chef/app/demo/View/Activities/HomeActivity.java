package com.chef.app.demo.View.Activities;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.chef.app.demo.Interfaces.DataProvider;
        import com.chef.app.demo.Interfaces.DeliveryManProfile;
        import com.chef.app.demo.R;

        import static com.chef.app.demo.AppManager.getInstance;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout pickupView,deliveryView, exchangeView, historyView;
    Intent pickup,delivery, exchange, history;
    TextView name,phone,address;
    DeliveryManProfile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        name = findViewById(R.id.delivery_man_name);
        phone = findViewById(R.id.delivery_man_phone);
        address = findViewById(R.id.delivery_man_address);

        DataProvider mData = getInstance().getDataManager();
        profile = mData.getDeliveryManProfile();
        name.setText(profile.getName());
        phone.setText(profile.getPhoneNumber());
        address.setText(profile.getAddress());


        pickup = new  Intent(this, PickUpActivity.class);
        delivery = new Intent(this, DeliveryActivity.class);
        exchange = new Intent(this, ExchangeDetailsActivity.class);

        pickupView = findViewById(R.id.ll_pick_up_home_option);
        pickupView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(HomeActivity.this, "Clicked Pickup", Toast.LENGTH_SHORT).show();
                startActivity(pickup);
            }
        });

        deliveryView = findViewById(R.id.ll_delivery_home_option);
        deliveryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(delivery);
            }
        });

        exchangeView = findViewById(R.id.ll_exchange_dashboard_option);
        exchangeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(exchange);
            }
        });

        history = new Intent(this, HistoryActivity.class);
        historyView = findViewById(R.id.ll_history_dashboard_option);
        historyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(history);
            }
        });
    }
}
