package com.healthtrack.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class that abstracts a physical exercise performed by the user.
 * A user can perform various exercise types throughout the day.
 * @author Marcelo Portella
 * @version 0.1
 */
public class PhysicalExercise implements Serializable {

    /**
     * Physical Exercise class objects version control.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Physical exercise date.
     */
    private Calendar exerciseDate;

    /**
     * Physical exercise duration in minutes.
     */
    private short exerciseDuration;

    /**
     * Total calories (kcal) burned in physical exercise.
     */
    private float exerciseCalories;

    /**
     * Default constructor for the PhysicalExercise class.
     */
    public PhysicalExercise() {
    }

    /**
     * Get the physical exercise date.
     * @return Physical exercise date.
     */
    public Calendar getExerciseDate() {
        return exerciseDate;
    }

    /**
     * Set the physical exercise date.
     * @param exerciseDate Physical exercise date.
     */
    public void setExerciseDate(Calendar exerciseDate) {
        this.exerciseDate = exerciseDate;
    }

    /**
     * Get the duration value (in minutes) of physical exercise.
     * @return Duration (minutes).
     */
    public short getExerciseDuration() {
        return exerciseDuration;
    }

    /**
     * Set the duration value (in minutes) of physical exercise.
     * @param exerciseDuration Duration (minutes).
     */
    public void setExerciseDuration(short exerciseDuration) {
        this.exerciseDuration = exerciseDuration;
    }

    /**
     * Gets the total calories burned in physical exercise.
     * @return Total calories burned (kcal).
     */
    public float getExerciseCalories() {
        return exerciseCalories;
    }

    /**
     * Sets the total calories (kcal) burned in physical exercise.
     * @param exerciseCalories Total calories burned (kcal).
     */
    public void setExerciseCalories(float exerciseCalories) {
        this.exerciseCalories = exerciseCalories;
    }


    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "PhysicalExercise{" +
                "exerciseDate=" + sdf.format(exerciseDate.getTime()) +
                ", exerciseDuration=" + exerciseDuration +
                ", exerciseCalories=" + exerciseCalories +
                '}';
    }


}