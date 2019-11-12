package com.mk.locationtracker.location;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public interface LocationUpdate {
    void onUpdateLocation(LatLng latlng, ArrayList<LatLng> points);
}
