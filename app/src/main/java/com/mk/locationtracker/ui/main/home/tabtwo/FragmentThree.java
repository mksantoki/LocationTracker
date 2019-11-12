package com.mk.locationtracker.ui.main.home.tabtwo;

import android.view.View;

import com.mk.locationtracker.R;
import com.mk.locationtracker.adapter.AdapterUserLocation;
import com.mk.locationtracker.ui.base.BaseFragment;
import com.mk.locationtracker.ui.main.home.ActivityHomePresenterImp;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class FragmentThree extends BaseFragment {
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

    public void updateUserLocationList(ArrayList<ActivityHomePresenterImp.UserLocationPoint> miterPoints) {
        adapterUserLocation.notifyDataList(miterPoints);
    }

}
