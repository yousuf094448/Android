package com.chef.app.demo.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chef.app.demo.Interfaces.PickUp;
import com.chef.app.demo.R;

import java.util.List;

public class PickUpRecyclerAdapter extends RecyclerView.Adapter<PickUpRecyclerAdapter.ViewHolder>{
    private List<PickUp> values;
    private Context context;
    private TextView chefName;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v.findViewById(R.id.pick_up_row_id);
            context = v.getContext();
            chefName = v.findViewById(R.id.chef_name);
        }
    }

    public PickUpRecyclerAdapter(List<PickUp> pickUpDataset) {
        values = pickUpDataset;
    }

    @Override
    public PickUpRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.pick_up_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PickUpRecyclerAdapter.ViewHolder holder, final int position) {


        chefName.setText(values.get(position).getName());
        Log.d(this.getClass().toString(), "onBindViewHolder: name = "+values.get(position).getName() + "position = "+position);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(this.getClass().toString(), "onClick: Item"+position);
                Intent pickUpDetailsIntent = new Intent(context,PickUpDetailsActivity.class);
                context.startActivity(pickUpDetailsIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
