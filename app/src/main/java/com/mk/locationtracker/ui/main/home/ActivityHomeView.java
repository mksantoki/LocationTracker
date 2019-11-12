package com.mk.locationtracker.ui.main.home;

import java.util.ArrayList;

public interface ActivityHomeView {

    void onUpdateLocation(String address);

    void showLocationUpdate(String address);

    void updateUserLocationList(ArrayList<ActivityHomePresenterImp.UserLocationPoint> miterPoints);

    void onUpdateDistance(String addressFromLocation, String addressFromLocation1, double distance);
}