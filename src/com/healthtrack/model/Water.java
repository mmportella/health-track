package com.healthtrack.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class that abstracts a user's water consumption.
 * A user can consume as much water as he wants, as many times a day as he wants.
 * @author Marcelo Portella
 * @version 0.1
 */
public class Water implements Serializable {

    /**
     * Water class objects version control.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Date of this water consumption.
     */
    private Calendar waterDate;

    /**
     * Volume of water consumed by the user at a time of day, in milli Liters (mL).
     */
    private short volume;

    /**
     * Water class default constructor.
     */
    public Water(){
    }

    /**
     * Get the date of this water consumption.
     * @return Date of water consumption.
     */
    public Calendar getWaterDate() {
        return waterDate;
    }

    /**
     * Set the date of this water consumption.
     */
    public void setWaterDate(Calendar waterDate) {
        this.waterDate = waterDate;
    }

    /**
     * Get the volume of water consumed by the user (mL).
     * @return Volume of water (mL).
     */
    public short getVolume() {
        return volume;
    }

    /**
     * Set the volume of water consumed by the user (mL).
     * @param volume Volume of water (mL).
     */
    public void setVolume(short volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Water{" +
                "waterDate=" + sdf.format(waterDate.getTime()) +
                ", volume=" + volume +
                '}';
    }


}