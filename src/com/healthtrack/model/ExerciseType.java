package com.healthtrack.model;

import java.io.Serializable;

/**
 * Class that abstracts a type of physical exercise that the user can perform.
 * A exercise type can be realized many times, many days by the user.
 * An exercise type can be entered into the database at the time of physical exercise recording.
 * So a type of physical exercise only exists if a user has already done it at least once.
 * @author Marcelo Portella
 * @version 0.1
 */
public class ExerciseType implements Serializable {

    /**
     * Physical Exercise class objects version control.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Exercise type ID number.
     */
    private int exTypeId;

    /**
     * Exercise type name and description.
     */
    private String exTypeDescription;

    /**
     * Calories burned (kcal) per minute of this exercise type.
     */
    private float kcalPerMinute;

    /**
     * Default constructor for the ExerciseType class.
     */
    public ExerciseType(){

    }

    /**
     * Get the exercise type ID number.
     * @return Exercise type ID.
     */
    public int getExTypeId() {
        return exTypeId;
    }

    /**
     * Set the exercise type ID number.
     * @param exTypeId Exercise type ID.
     */
    public void setExTypeId(int exTypeId) {
        this.exTypeId = exTypeId;
    }

    /**
     * Get the exercise type name and description.
     * @return Exercise type name.
     */
    public String getExTypeDescription() {
        return exTypeDescription;
    }

    /**
     * Get the exercise type name and description.
     * @param exTypeDescription Exercise type name.
     */
    public void setExTypeDescription(String exTypeDescription) {
        this.exTypeDescription = exTypeDescription;
    }

    /**
     * Get the calories burned per minute of this exercise type.
     * @return Calories burned per minute (kcal).
     */
    public float getKcalPerMinute() {
        return kcalPerMinute;
    }

    /**
     * Set the calories burned per minute of this exercise type.
     * @param kcalPerMinute Calories burned per minute (kcal).
     */
    public void setKcalPerMinute(float kcalPerMinute) {
        this.kcalPerMinute = kcalPerMinute;
    }

    @Override
    public String toString() {
        return "ExerciseType{" +
                "exTypeId=" + exTypeId +
                ", exTypeDescription='" + exTypeDescription + "'" +
                ", kcalPerMinute=" + kcalPerMinute +
                '}';
    }
}