import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    private Date exerciseDate;

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
     * @return Physical exercise date (String value).
     */
    public String getExerciseDate() {
        LocalDate date = exerciseDate.toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    /**
     * Set the physical exercise date from current date.
     */
    public void setExerciseDate() {
        this.exerciseDate = new Date(System.currentTimeMillis());
    }

    /**
     * Set the physical exercise date from a String date.
     * This String need to come in format: yyyy-[m]m-[d]d (optional zeroes of months and days).
     * @param exerciseDate Physical exercise date (String "yyyy-mm-dd").
     */
    public void setExerciseDate(String exerciseDate) {
        this.exerciseDate = Date.valueOf(exerciseDate);
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
}