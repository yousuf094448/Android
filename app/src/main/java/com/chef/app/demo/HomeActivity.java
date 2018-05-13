package com.chef.app.demo;

        import android.app.Activity;
        import android.content.Intent;
        import android.net.sip.SipSession;
        import android.os.Bundle;
        import android.support.v7.widget.CardView;
        import android.view.View;

public class HomeActivity extends Activity {

    private CardView pickupView,deliveryView;
    Intent pickup,delivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        pickup = new  Intent(this, PickUpActivity.class);
        delivery = new Intent(this, DeliveryActivity.class);

        pickupView = findViewById(R.id.pickUp_CardView);
        pickupView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(pickup);
            }
        });

        deliveryView = findViewById(R.id.deliveryCardView);
        deliveryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(delivery);
            }
        });
    }


}
