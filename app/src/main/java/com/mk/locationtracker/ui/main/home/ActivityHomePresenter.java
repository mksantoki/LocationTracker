package com.mk.locationtracker.ui.main.home;

/**
 * The interface Activity home presenter.
 */
public interface ActivityHomePresenter {

    /**
     * Request for location.
     */
    void requestForLocation();

    /**
     * Stop location update.
     */
    void stopLocationUpdate();
}
