import java.io.Serializable;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Class that abstracts the user's weight and body composition information on a given date.
 * A user can record this information once a day and can change or delete it.
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
    private Date weightDate;
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
     * Class default constructor.
     */
    public Weight() {
    }

    /**
     * Gets the weight and body composition information records date.
     * @return the date of this record.
     */
    public String getWeightDate() {
        LocalDate date = weightDate.toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    /**
     * Set the current weight date.
     * Convert the actual date in milliseconds to sql date.
     */
    public void setWeightDate() {
        this.weightDate = new Date(System.currentTimeMillis());
    }

    /**
     * Edit a weight date from a String date.
     * This String need to come in format: yyyy-[m]m-[d]d (optional zeroes of months and days).
     * @param weightDate Weight date (String "yyyy-mm-dd").
     */
    public void setWeightDate(String weightDate) {
        this.weightDate = Date.valueOf(weightDate);
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

}