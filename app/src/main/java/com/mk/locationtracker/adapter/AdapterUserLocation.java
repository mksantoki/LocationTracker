package com.mk.locationtracker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mk.locationtracker.R;
import com.mk.locationtracker.ui.main.home.ActivityHomePresenterImp;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterUserLocation extends RecyclerView.Adapter<AdapterUserLocation.MyViewHolder> {

    private ArrayList<ActivityHomePresenterImp.UserLocationPoint> miterPoints;

    public void notifyDataList(ArrayList<ActivityHomePresenterImp.UserLocationPoint> miterPoints) {
        this.miterPoints = miterPoints;
        notifyDataSetChanged();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        @BindView(R.id.tvDate)
        TextView tvDate;
        @BindView(R.id.tvAddress)
        TextView tvAddress;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterUserLocation(ArrayList<ActivityHomePresenterImp.UserLocationPoint> miterPoints) {
        this.miterPoints = miterPoints;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tab_three, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tvAddress.setText(miterPoints.get(position).getAddress().replace("\n",""));
        holder.tvDate.setText(miterPoints.get(position).getDateTime());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return miterPoints.size();
    }
}