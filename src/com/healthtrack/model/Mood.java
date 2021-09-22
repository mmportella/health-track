package com.healthtrack.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class that abstracts user's mood.
 * This functionality is intended to help users to track their mental health, which is also very important.
 * Users can set their mood once a day, modifying it if they want.
 * @author Marcelo Portella
 * @version 0.1
 */
public class Mood implements Serializable {

    /**
     * Mood class objects version control.
     */
    private static final long serialVersionUID = 1L;

    /**
     * User's mood record date.
     */
    private Calendar moodDate;

    /**
     * User's mood, represented as a percentage (0 to 100%).
     * Between 0% and 20%: Very Sad
     * Between 21% and 40%: Sad
     * Between 41% and 60%: Neutral
     * Between 61% and 80%: Happy
     * Between 81% and 100%: Very Happy
     */
    private byte mood;

    /**
     * Mood class default constructor.
     */
    public Mood(){
    }

    /**
     * Get the date of mood record.
     * @return Date of mood record.
     */
    public Calendar getMoodDate() {
        return moodDate;
    }

    /**
     * Set the date of mood record.
     */
    public void setMoodDate(Calendar moodDate) {
        this.moodDate = moodDate;
    }

    /**
     * Get the user's mood percentage.
     * @return User's mood percentage.
     */
    public byte getMood() {
        return mood;
    }

    /**
     * Set the user's mood percentage.
     * @param mood User's mood percentage.
     */
    public void setMood(byte mood) {
        this.mood = mood;
    }


    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Mood{" +
                "moodDate=" + sdf.format(moodDate.getTime()) +
                ", mood=" + mood +
                '}';
    }


}