package com.chef.app.demo.Activities;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.widget.CardView;
        import android.view.View;
        import android.widget.TextView;

        import com.chef.app.demo.AppManager;
        import com.chef.app.demo.Interfaces.DataProvider;
        import com.chef.app.demo.Interfaces.DeliveryManProfile;
        import com.chef.app.demo.R;

        import static com.chef.app.demo.AppManager.getInstance;

public class HomeActivity extends Activity {

    private CardView pickupView,deliveryView;
    Intent pickup,delivery;
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
        profile = mData.getUserProfile();
        name.setText(profile.getName());
        phone.setText(profile.getPhoneNumber());
        address.setText(profile.getAddress());


        pickup = new  Intent(this, PickUpActivity.class);
        delivery = new Intent(this, DeliveryActivity.class);

        pickupView = findViewById(R.id.pickUp_CardView);
        pickupView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {startActivity(pickup);
            }
        });

        deliveryView = findViewById(R.id.deliveryCardView);
        deliveryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {startActivity(delivery);
            }
        });
    }
}
