package com.mk.locationtracker.ui.main.home.tabthree;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;

import com.mk.locationtracker.R;
import com.mk.locationtracker.ui.base.BaseFragment;

import butterknife.BindView;

/**
 * The type Fragment two.
 */
public class FragmentTwo extends BaseFragment {
    /**
     * The Tv start location.
     */
    @BindView(R.id.tvStartLocation)
    TextView tvStartLocation;
    /**
     * The Tv end location.
     */
    @BindView(R.id.tvEndLocation)
    TextView tvEndLocation;
    /**
     * The Tv distance.
     */
    @BindView(R.id.tvDistance)
    TextView tvDistance;

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

    /**
     * Update start location.
     *
     * @param startLocation the start location
     */
    public void updateStartLocation(String startLocation) {
        tvStartLocation.setText(startLocation);
    }

    /**
     * Update end location.
     *
     * @param endLocation the end location
     */
    public void updateEndLocation(String endLocation) {
        tvEndLocation.setText(endLocation);
    }

    /**
     * Update user distance.
     *
     * @param distance the distance
     */
    public void updateUserDistance(double distance) {
        Resources res = getResources();
        tvDistance.setText(String.format(res.getString(R.string.mtrs), String.format("%.2f", distance)));
    }

}
