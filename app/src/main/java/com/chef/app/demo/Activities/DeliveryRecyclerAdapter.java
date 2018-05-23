package com.chef.app.demo.Activities;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chef.app.demo.Interfaces.Delivery;
import com.chef.app.demo.R;

public class DeliveryRecyclerAdapter extends RecyclerView.Adapter<DeliveryRecyclerAdapter.ViewHolder> {
    private List<Delivery> values;
    private Context context;
    private TextView customerName;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v.findViewById(R.id.deliveryRow);
            context = v.getContext();
        }
    }

    public void add(int position, String item) {
//        values.add(position, item);
//        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public DeliveryRecyclerAdapter(List<Delivery> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public DeliveryRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.delivery_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        customerName = holder.layout.findViewById(R.id.customer_name);
        customerName.setText(values.get(position).getName());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(this.getClass().toString(), "onClick: Item"+position);
                Intent deliveryDetailsActivity = new Intent(context,DeliveryDetailsActivity.class);
                context.startActivity(deliveryDetailsActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

}