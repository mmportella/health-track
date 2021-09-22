package com.healthtrack.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class that abstracts the user's Weight and Body Composition information (WBC) on a given date.
 * A user can record WBC once a day and can change or delete it.
 * While recording his weight, user can or can not record his corporal composition information.
 * @author Marcelo Portella
 * @version 0.1
 */
public class Weight implements Serializable {

    /**
     * Weight class objects version control.
     */
    private static final long serialVersionUID = 1L;



    /**
     * Date the user recorded the weight.
     */
    private Calendar weightDate;
    /**
     * User weight in kilograms.
     */
    private float weightNumber;
    /**
     * User's body fat percentage.
     */
    private float fatPercentage;
    /**
     * User's skeletal muscle percentage.
     */
    private float musclePercentage;
    /**
     * User's visceral fat percentage.
     */
    private float visceralPercentage;



    /**
     * Weight class default constructor.
     */
    public Weight() {
    }

    /**
     * Weight class weight-only constructor.
     */
    public Weight(Calendar weightDate, float weightNumber) {
        this.weightDate = weightDate;
        this.weightNumber = weightNumber;
    }

    /**
     * Weight class complete constructor.
     */
    public Weight(Calendar weightDate, float weightNumber, float fatPercentage, float musclePercentage, float visceralPercentage) {
        this.weightDate = weightDate;
        this.weightNumber = weightNumber;
        this.fatPercentage = fatPercentage;
        this.musclePercentage = musclePercentage;
        this.visceralPercentage = visceralPercentage;
    }



    /**
     * Gets the weight and body composition information records date.
     * @return the date of this record.
     */
    public Calendar getWeightDate() {
        return weightDate;
    }

    /**
     * Set the weight and body composition information records date.
     * @param weightDate the date of this record.
     */
    public void setWeightDate(Calendar weightDate) {
        this.weightDate = weightDate;
    }

    /**
     * Gets the user's weight on a certain date.
     * @return the user's weight on this date.
     */
    public float getWeightNumber() {
        return weightNumber;
    }

    /**
     * Changes the user's weight on a certain date.
     * @param weightNumber User's weight on this date.
     */
    public void setWeightNumber(float weightNumber) {
        this.weightNumber = weightNumber;
    }

    /**
     * Gets the user's body fat percentage on a given date.
     * @return the user's body fat percentage.
     */
    public float getFatPercentage() {
        return fatPercentage;
    }

    /**
     * Changes the user's body fat percentage on a certain date.
     * @param fatPercentage the user's body fat percentage.
     */
    public void setFatPercentage(float fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    /**
     * Gets the user's muscle percentage on a given date.
     * @return the user's muscle percentage.
     */
    public float getMusclePercentage() {
        return musclePercentage;
    }

    /**
     * Changes the user's muscle percentage on a certain date.
     * @param musclePercentage the user's muscle percentage.
     */
    public void setMusclePercentage(float musclePercentage) {
        this.musclePercentage = musclePercentage;
    }

    /**
     * Gets the user's visceral fat percentage on a given date.
     * @return the user's visceral fat percentage.
     */
    public float getVisceralPercentage() {
        return visceralPercentage;
    }

    /**
     * Changes the user's visceral fat percentage on a certain date.
     * @param visceralPercentage the user's visceral fat percentage.
     */
    public void setVisceralPercentage(float visceralPercentage) {
        this.visceralPercentage = visceralPercentage;
    }



    /**
     * Get the WBC object attributes information (String format).
     * @return WBC object.
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Weight{" +
                "weightDate=" + sdf.format(weightDate.getTime()) +
                ", weightNumber=" + weightNumber +
                ", fatPercentage=" + fatPercentage +
                ", musclePercentage=" + musclePercentage +
                ", visceralPercentage=" + visceralPercentage +
                '}';
    }



}