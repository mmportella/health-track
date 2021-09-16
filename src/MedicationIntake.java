import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Time;

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
    private Date medDate;

    /**
     * Time of the day that user took the medication.
     */
    private Time medTime;

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
     * @return Medication intake date (String value).
     */
    public String getMedDate() {
        LocalDate date = medDate.toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    /**
     * Set the medication intake date, from current date.
     */
    public void setMedDate() {
        this.medDate = new Date(System.currentTimeMillis());
    }

    /**
     * Set the medication intake date, from a String date.
     * This String need to come in format: yyyy-[m]m-[d]d (optional zeroes of months and days).
     * @param medDate Medication intake date (String "yyyy-mm-dd").
     */
    public void setMedDate(String medDate) {
        this.medDate = Date.valueOf(medDate);
    }

    /**
     * Get the medication intake time.
     * @return Medication intake time (String value "hh:mm").
     */
    public String getMedTime() {
        return new StringBuilder(this.medTime.toString()).delete(5,9).toString();
    }

    /**
     * Set the medication intake time, from current time.
     */
    public void setMedTime() {
        this.medTime = new Time(System.currentTimeMillis());
    }

    /**
     * Set the medication intake time, from a given time (String value).
     * This String need to come in format: "hh:mm"
     * @param medTime Medication intake time (String "hh:mm").
     */
    public void setMedTime(String medTime) {
        this.medTime = Time.valueOf(medTime + ":00");
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

}