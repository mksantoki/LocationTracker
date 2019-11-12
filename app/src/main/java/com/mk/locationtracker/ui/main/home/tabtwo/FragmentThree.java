package com.mk.locationtracker.ui.main.home.tabtwo;

import android.view.View;

import com.mk.locationtracker.R;
import com.mk.locationtracker.adapter.AdapterUserLocation;
import com.mk.locationtracker.model.UserLocationPoint;
import com.mk.locationtracker.ui.base.BaseFragment;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * The type Fragment three.
 */
public class FragmentThree extends BaseFragment {
    /**
     * The Recyclerview.
     */
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private AdapterUserLocation adapterUserLocation;

    @Override
    protected int setLayout() {
        return R.layout.fragment_tab_three;
    }

    @Override
    protected void initListener() {
        adapterUserLocation=new AdapterUserLocation(new ArrayList<>());
        recyclerview.setAdapter(adapterUserLocation);
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initControl() {

    }

    /**
     * Update user location list.
     *
     * @param miterPoints the miter points
     */
    public void updateUserLocationList(ArrayList<UserLocationPoint> miterPoints) {
        adapterUserLocation.notifyDataList(miterPoints);
    }

}
