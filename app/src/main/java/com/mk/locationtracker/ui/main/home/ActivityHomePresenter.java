package com.mk.locationtracker.ui.main.home;

public interface ActivityHomePresenter {

    void requestForLocation();

    double distance(double lat1, double lon1, double lat2, double lon2);
}
