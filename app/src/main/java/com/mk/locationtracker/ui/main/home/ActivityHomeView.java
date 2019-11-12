package com.mk.locationtracker.ui.main.home;

import android.content.Context;
import android.content.Intent;

import com.mk.locationtracker.model.UserLocationPoint;

import java.util.ArrayList;

/**
 * The interface Activity home view.
 */
public interface ActivityHomeView {

    /**
     * Request location permission.
     */
    void requestLocationPermission();

    /**
     * Check permissions boolean.
     *
     * @return the boolean
     */
    boolean checkPermissions();

    /**
     * On update location.
     *
     * @param address the address
     */
    void onUpdateLocation(String address);

    /**
     * Update user location.
     *
     * @param address the address
     */
    void updateUserLocation(String address);

    /**
     * Show location update.
     *
     * @param address the address
     */
    void showLocationUpdate(String address);

    /**
     * Update user location list.
     *
     * @param miterPoints the miter points
     */
    void updateUserLocationList(ArrayList<UserLocationPoint> miterPoints);

    /**
     * On update distance.
     *
     * @param addressFromLocation  the address from location
     * @param addressFromLocation1 the address from location 1
     * @param distance             the distance
     */
    void onUpdateDistance(String addressFromLocation, String addressFromLocation1, double distance);

    /**
     * Show notification message.
     *
     * @param context   the context
     * @param title     the title
     * @param message   the message
     * @param timeStamp the time stamp
     * @param intent    the intent
     */
    void showNotificationMessage(Context context, String title, String message, String timeStamp, Intent intent);
}