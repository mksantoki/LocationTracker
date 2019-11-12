package com.mk.locationtracker.ui.main.home.tabthree;

import android.view.View;
import android.widget.TextView;

import com.mk.locationtracker.R;
import com.mk.locationtracker.ui.base.BaseFragment;

import androidx.cardview.widget.CardView;
import butterknife.BindView;

public class FragmentTwo extends BaseFragment {
    @BindView(R.id.tvStartLocation)
    TextView tvStartLocation;
    @BindView(R.id.tvStartLocationTitle)
    TextView tvStartLocationTitle;
    @BindView(R.id.cardViewStartLocation)
    CardView cardViewStartLocation;
    @BindView(R.id.tvEndLocation)
    TextView tvEndLocation;
    @BindView(R.id.tvEndLocationTitle)
    TextView tvEndLocationTitle;
    @BindView(R.id.catdViewEndLocation)
    CardView catdViewEndLocation;
    @BindView(R.id.tvDistance)
    TextView tvDistance;
    @BindView(R.id.tvDistanceTitle)
    TextView tvDistanceTitle;
    @BindView(R.id.cardViewDis)
    CardView cardViewDis;

    @Override
    protected int setLayout() {
        return R.layout.fragment_tab_two;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initControl() {

    }

    public void updateStartLocation(String startLocation) {
        tvStartLocation.setText(startLocation);
    }

    public void updateEndLocation(String endLocation) {
        tvEndLocation.setText(endLocation);
    }

    public void updateUserDistance(double distance) {
        tvDistance.setText(String.format("%.2f", distance) + " mtrs");
    }

}
