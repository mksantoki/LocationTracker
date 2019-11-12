package com.mk.locationtracker.utiles;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.mk.locationtracker.utiles.Constant.dateFormat;

/**
 * The type Date util.
 */
public class DateUtil {
    /**
     * Gets date time.
     *
     * @return the date time
     */
    public static String getDateTime() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat(dateFormat);
        String formatted = format1.format(cal.getTime());
        return formatted;
    }
}
