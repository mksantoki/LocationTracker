package com.mk.locationtracker.location;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * The interface Location update.
 */
public interface LocationUpdate {
    /**
     * On update location.
     *
     * @param latlng the latlng
     * @param points the points
     */
    void onUpdateLocation(LatLng latlng, ArrayList<LatLng> points);
}
