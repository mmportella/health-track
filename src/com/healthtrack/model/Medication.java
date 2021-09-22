package com.healthtrack.model;

import java.io.Serializable;

/**
 * Class that represents a medication that can be taken by the user.
 * A medication can be taken once, none or several times a day, in different dosages.
 * A medication can be entered into the database at the time of medication intake recording.
 * So a medication only exists if a user has already taken it at least once.
 * @author Marcelo Portella
 * @version 0.1
 */
public class Medication implements Serializable {

    /**
     * Medication class objects version control.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Medication ID number.
     */
    private int medId;

    /**
     * Medication name.
     */
    private String medName;

    /**
     * Medication default dosage strength in milligrams.
     */
    private double medDosage;

    /**
     * Default constructor for the Medication class.
     */
    public Medication(){
    }

    /**
     * Get the medication ID number.
     * @return Medication ID.
     */
    public int getMedId() {
        return medId;
    }

    /**
     * Set the medication ID number.
     * @param medId Medication ID.
     */
    public void setMedId(int medId) {
        this.medId = medId;
    }

    /**
     * Get the medication name.
     * @return Medication name.
     */
    public String getMedName() {
        return medName;
    }

    /**
     * Set the medication name.
     * @param medName Medication name.
     */
    public void setMedName(String medName) {
        this.medName = medName;
    }

    /**
     * Get the medication default dosage strength.
     * @return Medication dosage strength (milligrams).
     */
    public double getMedDosage() {
        return medDosage;
    }

    /**
     * Set the medication default dosage strength.
     * @param medDosage Medication dosage strength (milligrams).
     */
    public void setMedDosage(double medDosage) {
        this.medDosage = medDosage;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "medId=" + medId +
                ", medName='" + medName +
                ", medDosage=" + medDosage +
                '}';
    }
}