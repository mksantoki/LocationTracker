package com.mk.locationtracker.ui.main.home;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;
import com.mk.locationtracker.location.LocationManger;
import com.mk.locationtracker.location.LocationUpdate;
import com.mk.locationtracker.model.UserLocationPoint;

import java.util.ArrayList;

import static com.mk.locationtracker.utiles.DateUtil.getDateTime;
import static com.mk.locationtracker.utiles.UtilGeocoder.getAddressFromLocation;
import static com.mk.locationtracker.utiles.Utils.checkLocationMiter;
import static com.mk.locationtracker.utiles.Utils.distance;

/**
 * The type Activity home presenter imp.
 */
public class ActivityHomePresenterImp implements ActivityHomePresenter, LocationUpdate {
    /**
     * The Context.
     */
    Context context;
    /**
     * The View.
     */
    ActivityHomeView view;
    /**
     * The Location manger.
     */
    LocationManger locationManger;
    /**
     * The Miter points.
     */
    public ArrayList<UserLocationPoint> miterPoints = new ArrayList<>();
    /**
     * The Last index.
     */
    int lastIndex = 0;

    /**
     * Instantiates a new Activity home presenter imp.
     *
     * @param context the context
     * @param view    the view
     */
    public ActivityHomePresenterImp(Context context, ActivityHomeView view) {
        this.context = context;
        this.view = view;
    }

    public void requestForLocation() {
        locationManger = new LocationManger(context, this);
    }

    @Override
    public void stopLocationUpdate() {
        if(locationManger!=null){
            locationManger.stopLocationUpdate();
        }
    }


    @Override
    public void onUpdateLocation(LatLng latlng, ArrayList<LatLng> points) {
        String address = getAddressFromLocation(context, latlng.latitude, latlng.longitude);
        view.onUpdateLocation(address);
        view.onUpdateDistance(getAddressFromLocation(context, points.get(0).latitude, points.get(0).longitude), getAddressFromLocation(context, latlng.latitude, latlng.longitude), distance(points.get(0).latitude, points.get(0).longitude, latlng.latitude, latlng.longitude));
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
}
