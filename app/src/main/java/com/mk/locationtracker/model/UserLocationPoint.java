package com.mk.locationtracker.model;

/**
 * The type User location point.
 */
public class UserLocationPoint {
    private String address;
    private String dateTime;

    /**
     * Instantiates a new User location point.
     *
     * @param address  the address
     * @param dateTime the date time
     */
    public UserLocationPoint(String address, String dateTime) {
        this.address = address;
        this.dateTime = dateTime;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets date time.
     *
     * @return the date time
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Sets date time.
     *
     * @param dateTime the date time
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}