package com.healthtrack.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class that abstracts the user's heart health and pressure parameters.
 * The user can record all the informations about their heart once a day, and can modify it if necessary.
 * @author Marcelo Portella
 * @version 0.1
 */
public class Heart implements Serializable {

    /**
     * Heart class objects version control.
     */
    private static final long serialVersionUID = 1L;

    /**
     * User's heart information record date.
     */
    private Calendar heartDate;

    /**
     * User's heart rate, in beats per minute.
     */
    private short bpm;

    /**
     * User's systolic pressure, in mmHg.
     */
    private short systolic;

    /**
     * User's diastolic pressure, in mmHg.
     */
    private short diastolic;

    /**
     * Default constructor for the Heart class.
     */
    public Heart(){
    }

    /**
     * Get the heart information record date.
     * @return Heart information record date.
     */
    public Calendar getHeartDate() {
        return heartDate;
    }

    /**
     * Get the heart information record date.
     * @param heartDate Heart information record date.
     */
    public void setHeartDate(Calendar heartDate) {
        this.heartDate = heartDate;
    }

    /**
     * Get the user's heart rate.
     * @return User's heart rate (BPM).
     */
    public short getBpm() {
        return bpm;
    }

    /**
     * Set the user's heart rate.
     * @param bpm User's heart rate (BPM).
     */
    public void setBpm(short bpm) {
        this.bpm = bpm;
    }

    /**
     * Get the user's systolic pressure, in mmHg.
     * @return Systolic pressure (mmHg).
     */
    public short getSystolic() {
        return systolic;
    }

    /**
     * Get the user's systolic pressure, in mmHg.
     * @param systolic Systolic pressure (mmHg).
     */
    public void setSystolic(short systolic) {
        this.systolic = systolic;
    }

    /**
     * Get the user's diastolic pressure, in mmHg.
     * @return Diastolic pressure (mmHg).
     */
    public short getDiastolic() {
        return diastolic;
    }

    /**
     * Get the user's diastolic pressure, in mmHg.
     * @param diastolic Diastolic pressure (mmHg).
     */
    public void setDiastolic(short diastolic) {
        this.diastolic = diastolic;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Heart{" +
                "heartDate=" + sdf.format(heartDate.getTime()) +
                ", bpm=" + bpm +
                ", systolic=" + systolic +
                ", diastolic=" + diastolic +
                '}';
    }
}