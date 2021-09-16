import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    private Date moodDate;

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
     * @return Date of mood record (String value).
     */
    public String getMoodDate() {
        LocalDate date = moodDate.toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    /**
     * Set the date of mood record, from current date.
     */
    public void setMoodDate() {
        this.moodDate = new Date(System.currentTimeMillis());
    }

    /**
     * Set the date of mood record, from a given String date.
     * This String need to come in format: yyyy-[m]m-[d]d (optional zeroes of months and days).
     * @param waterDate Date of mood record (String "yyyy-mm-dd").
     */
    public void setWaterDate(String waterDate) {
        this.moodDate = Date.valueOf(waterDate);
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

}