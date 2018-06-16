package com.chef.app.demo.View.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chef.app.demo.Interfaces.PickUp;
import com.chef.app.demo.R;
import com.chef.app.demo.View.Activities.PickUpDetailsActivity;
import com.chef.app.demo.View.DragAndDrop.DragAndDropAdapter;
import com.chef.app.demo.View.DragAndDrop.DragAndDropViewHolder;

import java.util.List;

public class PickUpRecyclerAdapter extends RecyclerView.Adapter<PickUpRecyclerAdapter.ViewHolder> implements DragAndDropAdapter {
    private List<PickUp> values;
    private Context context;
    private TextView chefName, chefAddress, pickUpCount, pickUpStatus, chefPhone;
    private LinearLayout chefPfofile;


    public PickUpRecyclerAdapter(List<PickUp> pickUpDataset) {
        values = pickUpDataset;
    }

    @NonNull
    @Override
    public PickUpRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.pick_up_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PickUpRecyclerAdapter.ViewHolder holder, final int position) {
        chefName = holder.layout.findViewById(R.id.chef_name);
        chefAddress = holder.layout.findViewById(R.id.pick_up_address);
        pickUpCount = holder.layout.findViewById(R.id.pick_up_count);
        pickUpStatus = holder.layout.findViewById(R.id.pick_up_status);
        chefPhone = holder.layout.findViewById(R.id.pick_up_phone);


        chefName.setText(values.get(position).getName());
        chefAddress.setText(values.get(position).getAddress());
        chefPhone.setText(values.get(position).getPhoneNumber());
        pickUpCount.setText(values.get(position).getNumberOfPackets());
        pickUpStatus.setText(values.get(position).getPickUpStatus());

        Log.d(this.getClass().toString(), "onBindViewHolder: name = "+values.get(position).getName() + "position = "+position);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(this.getClass().toString(), "onClick: Item"+position);
                Intent pickUpDetailsIntent = new Intent(context,PickUpDetailsActivity.class);
                pickUpDetailsIntent.putExtra("SELECTED_ITEM",position);
                context.startActivity(pickUpDetailsIntent);
            }
        });

        chefPfofile = holder.layout.findViewById(R.id.pick_up_chef_profile);
        chefPfofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", values.get(position).getPhoneNumber(),null)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }


    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        PickUp prev = values.remove(fromPosition);
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

        public ViewHolder(View v) {
            super(v);
            layout = v.findViewById(R.id.pick_up_row_id);
            context = v.getContext();
        }

        @Override
        public void onItemSelected() {
            
        }

        @Override
        public void onItemClear() {

        }
    }

}
