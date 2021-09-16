import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Class that abstracts a user's water consumption.
 * A user can consume as much water as he wants, as many times a day as he wants.
 * @author Marcelo Portella
 * @version 0.1
 */
public class Water implements Serializable {

    /**
     * Water class objects version control.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Date of this water consumption.
     */
    private Date waterDate;

    /**
     * Volume of water consumed by the user at a time of day, in milli Liters (mL).
     */
    private short volume;

    /**
     * Water class default constructor.
     */
    public Water(){
    }

    /**
     * Get the date of this water consumption.
     * @return Date of water consumption (String value).
     */
    public String getWaterDate() {
        LocalDate date = waterDate.toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    /**
     * Set the date of this water consumption, from current date.
     */
    public void setWaterDate() {
        this.waterDate = new Date(System.currentTimeMillis());
    }

    /**
     * Set the date of this water consumption, from a given String date.
     * This String need to come in format: yyyy-[m]m-[d]d (optional zeroes of months and days).
     * @param waterDate Date of water consumption (String "yyyy-mm-dd").
     */
    public void setWaterDate(String waterDate) {
        this.waterDate = Date.valueOf(waterDate);
    }

    /**
     * Get the volume of water consumed by the user (mL).
     * @return Volume of water (mL).
     */
    public short getVolume() {
        return volume;
    }

    /**
     * Set the volume of water consumed by the user (mL).
     * @param volume Volume of water (mL).
     */
    public void setVolume(short volume) {
        this.volume = volume;
    }

}