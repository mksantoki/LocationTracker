package com.mk.locationtracker.ui.main.home;

import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mk.locationtracker.R;
import com.mk.locationtracker.ui.base.BaseActivity;
import com.mk.locationtracker.ui.main.home.tabone.FragmentOne;
import com.mk.locationtracker.ui.main.home.tabthree.FragmentTwo;
import com.mk.locationtracker.ui.main.home.tabtwo.FragmentThree;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import butterknife.BindView;

public class ActivityHome extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    @Override
    protected void initListener() {
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void initView() {
        loadFragment(new FragmentOne());
    }

    @Override
    protected void initControl() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_home;
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()) {
            case R.id.navigation_tab_one:
                fragment = new FragmentOne();
                break;

            case R.id.navigation_tab_two:
                fragment = new FragmentTwo();
                break;

            case R.id.navigation_tab_three:
                fragment = new FragmentThree();
                break;
        }

        return loadFragment(fragment);
    }
}
