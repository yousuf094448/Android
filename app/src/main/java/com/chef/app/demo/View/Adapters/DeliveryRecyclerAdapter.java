package com.chef.app.demo.View.Adapters;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chef.app.demo.Interfaces.Delivery;
import com.chef.app.demo.R;
import com.chef.app.demo.View.Activities.DeliveryDetailsActivity;
import com.chef.app.demo.View.DragAndDrop.DragAndDropAdapter;
import com.chef.app.demo.View.DragAndDrop.DragAndDropViewHolder;

public class DeliveryRecyclerAdapter extends RecyclerView.Adapter<DeliveryRecyclerAdapter.ViewHolder> implements DragAndDropAdapter {
    private List<Delivery> values;
    private Context context;
    private TextView customerName, customerAddress, deliveryCount, deliveryStatus, custormerPhone;
    private LinearLayout customerProfile;


    public DeliveryRecyclerAdapter(List<Delivery> myDataset) {
        values = myDataset;
    }

    @Override
    public DeliveryRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.delivery_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        customerName = holder.layout.findViewById(R.id.customer_name);
        customerAddress = holder.layout.findViewById(R.id.customer_address);
        custormerPhone = holder.layout.findViewById(R.id.customer_phone);
        deliveryCount = holder.layout.findViewById(R.id.delivery_count);
        deliveryStatus = holder.layout.findViewById(R.id.delivery_status);
        customerProfile = holder.layout.findViewById(R.id.customer_profile);


        customerName.setText(values.get(position).getName());
        custormerPhone.setText(values.get(position).getPhoneNumber());
        customerAddress.setText(values.get(position).getAddress());
        deliveryStatus.setText(values.get(position).getDeliverySttus());
        deliveryCount.setText(values.get(position).getDeliveryCount());

        customerProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", values.get(position).getPhoneNumber(), null)));
            }
        });

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d(this.getClass().toString(), "onClick: Item" + position);
                Intent deliveryDetailsActivity = new Intent(context, DeliveryDetailsActivity.class);
                context.startActivity(deliveryDetailsActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Delivery prev = values.remove(fromPosition);
        values.add(toPosition > fromPosition ? toPosition - 1 : toPosition, prev);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements DragAndDropViewHolder {
        public View layout;

        ViewHolder(View v) {
            super(v);
            layout = v.findViewById(R.id.deliveryRow);
            context = v.getContext();
        }

        @Override
        public void onItemSelected() {

        }

        @Override
        public void onItemClear() {

        }
    }

//    public void add(int position, String item) {
//        values.add(position, item);
//        notifyItemInserted(position);
//    }

//    public void remove(int position) {
//        values.remove(position);
//        notifyItemRemoved(position);
//    }


}