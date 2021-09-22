package com.healthtrack.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class that abstracts a user's medication intake.
 * This functionality is intended to help the user remember to take the medication, and track the days he took.
 * A user can take as many medications as needed, as often as needed.
 * @author Marcelo Portella
 * @version 0.1
 */
public class MedicationIntake implements Serializable {

    /**
     * IntakeMedication class objects version control.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Medication intake date.
     */
    private Calendar medDate;

    /**
     * Time of the day that user took the medication.
     */
    private Date medTime;

    /**
     * Dosage of a medication (milligrams) that the user took at this time.
     */
    private double medDosage;

    /**
     * Default constructor for the Medication Intake class.
     */
    public MedicationIntake(){
    };

    /**
     * Get the medication intake date.
     * @return Medication intake date.
     */
    public Calendar getMedDate() {
        return medDate;
    }

    /**
     * Set the medication intake date.
     */
    public void setMedDate(Calendar medDate) {
        this.medDate = medDate;
    }

    /**
     * Get the medication intake time.
     * @return Medication intake time.
     */
    public Date getMedTime() {
        return medTime;
    }

    /**
     * Set the medication intake time.
     */
    public void setMedTime(Date medTime) {
        this.medTime = medTime;
    }

    /**
     * Get the took dosage of this medication.
     * @return Medication dosage (milligrams).
     */
    public double getMedDosage() {
        return medDosage;
    }

    /**
     * Set the took dosage of this medication.
     * @param medDosage Medication dosage (milligrams).
     */
    public void setMedDosage(double medDosage) {
        this.medDosage = medDosage;
    }



    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String medTimeStr = new StringBuilder(this.medTime.toString()).delete(5,9).toString();
        return "MedicationIntake{" +
                "medDate=" + sdf.format(medDate.getTime()) +
                ", medTime=" + medTimeStr +
                ", medDosage=" + medDosage +
                '}';
    }


}