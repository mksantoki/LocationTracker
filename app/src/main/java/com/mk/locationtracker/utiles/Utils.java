package com.mk.locationtracker.utiles;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

import static com.mk.locationtracker.utiles.Constant.distanceMeter;

/**
 * The type Utils.
 */
public class Utils {

    /**
     * Check location miter boolean.
     *
     * @param startPoint the start point
     * @param endpoint   the endpoint
     * @return the boolean
     */
    public static boolean checkLocationMiter(LatLng startPoint, LatLng endpoint) {
        double distance = distance(startPoint.latitude, startPoint.longitude, endpoint.latitude, endpoint.longitude);
        if (distance >= distanceMeter) {
            return true;
        }
        return false;
    }

    /**
     * Distance double.
     *
     * @param lat1 the lat 1
     * @param lon1 the lon 1
     * @param lat2 the lat 2
     * @param lon2 the lon 2
     * @return the double
     */
    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        double dist;
        Location locationA = new Location("Point A");
        locationA.setLatitude(lat1);
        locationA.setLongitude(lon1);

        Location locationB = new Location("Point B");
        locationB.setLatitude(lat2);
        locationB.setLongitude(lon2);

        dist = locationA.distanceTo(locationB);   // in meters
        return (dist);
    }

}
