package com.mk.locationtracker.utiles;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import com.mk.locationtracker.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * The type Util geocoder.
 */
public class UtilGeocoder {
    private static final String TAG = UtilGeocoder.class.getSimpleName();

    /**
     * Gets address from location.
     *
     * @param context   the context
     * @param latitude  the latitude
     * @param longitude the longitude
     * @return the address from location
     */
    public static String getAddressFromLocation(Context context, double latitude, double longitude) {
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
        return context.getString(R.string.sorry_for_delay_we_are_try_to_find_your_location);
    }
}
