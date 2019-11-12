package com.mk.locationtracker.ui.main.home.tabone;

import android.view.View;
import android.widget.TextView;

import com.mk.locationtracker.R;
import com.mk.locationtracker.ui.base.BaseFragment;

import butterknife.BindView;

/**
 * The type Fragment one.
 */
public class FragmentOne extends BaseFragment {
    @BindView(R.id.tvUserLocation)
    TextView tvUserLocation;

    @Override
    protected int setLayout() {
        return R.layout.fragment_tab_one;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {
        tvUserLocation.setText(getString(R.string.please_wait_we_are_try_to_find_your_address));
    }

    @Override
    protected void initControl() {

    }
    public void updateUserLocation(String address){
        tvUserLocation.setText(address);
    }
}
