package com.mk.locationtracker.ui.main.home;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.mk.locationtracker.BuildConfig;
import com.mk.locationtracker.R;
import com.mk.locationtracker.model.UserLocationPoint;
import com.mk.locationtracker.notificationutils.NotificationUtils;
import com.mk.locationtracker.ui.base.BaseActivity;
import com.mk.locationtracker.ui.main.home.tabone.FragmentOne;
import com.mk.locationtracker.ui.main.home.tabthree.FragmentTwo;
import com.mk.locationtracker.ui.main.home.tabtwo.FragmentThree;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import butterknife.BindView;

/**
 * The type Activity home.
 */
public class ActivityHome extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ActivityHomeView {
    /**
     * The Main container.
     */
    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    /**
     * The Navigation.
     */
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    private ActivityHomePresenter presenter;
    private Fragment currentFragment = null;

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
        presenter = new ActivityHomePresenterImp(this, this);
        requestLocationPermission();
    }

    @Override
    public void requestLocationPermission() {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        presenter.requestForLocation();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        if (response.isPermanentlyDenied()) {
                            // open device settings when the permission is
                            // denied permanently
                            openSettings();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_home;
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            currentFragment = fragment;
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
        if (!checkPermissions()) {
            requestLocationPermission();
            return false;
        }
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

    private void openSettings() {
        Intent intent = new Intent();
        intent.setAction(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package",
                BuildConfig.APPLICATION_ID, null);
        intent.setData(uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public boolean checkPermissions() {
        int permissionState = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onUpdateLocation(String address) {
        updateUserLocation(address);
    }

    @Override
    public void updateUserLocation(String address) {
        if (currentFragment instanceof FragmentOne) {
            FragmentOne temp = (FragmentOne) currentFragment;
            temp.updateUserLocation(address);
        }
    }

    @Override
    public void showLocationUpdate(String address) {
        Intent resultIntent = new Intent(this, ActivityHome.class);
        resultIntent.putExtra("message", "test");
        showNotificationMessage(getApplicationContext(), getString(R.string.mtrs_completed), address, "", resultIntent);

    }

    @Override
    public void updateUserLocationList(ArrayList<UserLocationPoint> miterPoints) {
        if (currentFragment instanceof FragmentThree) {
            FragmentThree temp = (FragmentThree) currentFragment;
            temp.updateUserLocationList(miterPoints);
        }
    }

    @Override
    public void onUpdateDistance(String startLocation, String endLocation, double distance) {
        if (currentFragment instanceof FragmentTwo) {
            FragmentTwo temp = (FragmentTwo) currentFragment;
            temp.updateStartLocation(startLocation);
            temp.updateEndLocation(endLocation);
            temp.updateUserDistance(distance);

        }
    }

    @Override
    public void showNotificationMessage(Context context, String title, String message, String timeStamp, Intent intent) {
        NotificationUtils notificationUtils = new NotificationUtils(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        notificationUtils.showNotificationMessage(title, message, timeStamp, intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.stopLocationUpdate();
    }
}
