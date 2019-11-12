package com.mk.locationtracker.ui.main.home;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.mk.locationtracker.location.LocationManger;
import com.mk.locationtracker.location.LocationUpdate;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ActivityHomePresenterImp implements ActivityHomePresenter, LocationUpdate {

    private static final String TAG = ActivityHomePresenterImp.class.getSimpleName();

    Context context;
    ActivityHomeView view;
    LocationManger locationManger;
    public ArrayList<UserLocationPoint> miterPoints = new ArrayList<>();

    public ActivityHomePresenterImp(Context context, ActivityHomeView view) {
        this.context = context;
        this.view = view;
    }

    public void requestForLocation() {
        locationManger = new LocationManger(context, this);
    }

    public String getAddressFromLocation(double latitude, double longitude) {
        try {
            Geocoder geocoder;
            List<Address> addresses;
            geocoder = new Geocoder(context, Locale.getDefault());
            addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            if (addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");

                for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                }
                return strReturnedAddress.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
        return "Sorry for delay. We are try to find your location";
    }

    @Override
    public double distance(double lat1, double lon1, double lat2, double lon2) {
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

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    int lastIndex = 0;

    @Override
    public void onUpdateLocation(LatLng latlng, ArrayList<LatLng> points) {
        String address = getAddressFromLocation(latlng.latitude, latlng.longitude);
        view.onUpdateLocation(address);
        view.onUpdateDistance(getAddressFromLocation(points.get(0).latitude, points.get(0).longitude), getAddressFromLocation(latlng.latitude, latlng.longitude), distance(points.get(0).latitude, points.get(0).longitude, latlng.latitude, latlng.longitude));
        if (points != null && points.size() > 1) {
            if (checkLocationMiter(points.get(lastIndex), latlng)) {
                miterPoints.add(new UserLocationPoint(address, getDateTime()));
                view.showLocationUpdate(address);
                lastIndex = points.size() - 1;
            }
        }
        if (miterPoints.size() > 0) {
            view.updateUserLocationList(miterPoints);
        }
    }

    public String getDateTime() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss a");
        String formatted = format1.format(cal.getTime());
        return formatted;
    }

    private boolean checkLocationMiter(LatLng startPoint, LatLng endpoint) {
        double distance = distance(startPoint.latitude, startPoint.longitude, endpoint.latitude, endpoint.longitude);
        if (distance >= 50) {
            return true;
        }
        return false;
    }

    public class UserLocationPoint {
        private String address;
        private String dateTime;

        public UserLocationPoint(String address, String dateTime) {
            this.address = address;
            this.dateTime = dateTime;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }
    }

}
