package com.mk.locationtracker.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import com.mk.locationtracker.R;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * The type View holder user location.
 */
public class ViewHolderUserLocation extends RecyclerView.ViewHolder {
    /**
     * The Tv date.
     */
    @BindView(R.id.tvDate)
    public TextView tvDate;
    /**
     * The Tv address.
     */
    @BindView(R.id.tvAddress)
    public TextView tvAddress;

    /**
     * Instantiates a new View holder user location.
     *
     * @param view the view
     */
    public ViewHolderUserLocation(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}