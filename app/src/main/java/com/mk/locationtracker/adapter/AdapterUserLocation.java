package com.mk.locationtracker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mk.locationtracker.R;
import com.mk.locationtracker.adapter.viewholder.ViewHolderUserLocation;
import com.mk.locationtracker.model.UserLocationPoint;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

/**
 * The type Adapter user location.
 */
public class AdapterUserLocation extends RecyclerView.Adapter<ViewHolderUserLocation> {

    private ArrayList<UserLocationPoint> miterPoints;

    /**
     * Notify data list.
     *
     * @param miterPoints the miter points
     */
    public void notifyDataList(ArrayList<UserLocationPoint> miterPoints) {
        this.miterPoints = miterPoints;
        notifyDataSetChanged();
    }

    /**
     * Instantiates a new Adapter user location.
     *
     * @param miterPoints the miter points
     */
    public AdapterUserLocation(ArrayList<UserLocationPoint> miterPoints) {
        this.miterPoints = miterPoints;
    }

    @Override
    public ViewHolderUserLocation onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tab_three, parent, false);
        ViewHolderUserLocation myViewHolder = new ViewHolderUserLocation(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderUserLocation holder, int position) {
        holder.tvAddress.setText(miterPoints.get(position).getAddress().replace("\n",""));
        holder.tvDate.setText(miterPoints.get(position).getDateTime());
    }

    @Override
    public int getItemCount() {
        return miterPoints.size();
    }
}