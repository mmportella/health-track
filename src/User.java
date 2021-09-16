import java.io.Serializable;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Class that represents a user of the Health Track system.
 * A user can record various types of information about their health, in as many days as they like.
 * @author Marcelo Portella
 * @version 0.1
 */
public class User implements Serializable {

    /**
     * User class objects version control.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Unique user identification within the Health Track system.
     */
    private int userId;
    /**
     * User email.
     */
    private String userEmail;
    /**
     * User password hash.
     */
    private String userPassword;
    /**
     * User name.
     */
    private String userName;
    /**
     * User birthdate.
     */
    private Date userBirthdate;
    /**
     * User height (cm).
     */
    private short userHeight;
    /**
     * User gender (M or F).
     */
    private char userGender;
    /**
     * User phone number.
     */
    private long userPhone;

    /**
     * Class default constructor.
     */
    public User(){
    }

    /**
     * Gets the user ID.
     * @return the user ID number.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     * @param userId user ID.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the user e-mail.
     * @return the user's e-mail.
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets the user e-mail.
     * @param userEmail User's e-mail.
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Get User Password.
     * @return user password.
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets the user password.
     * @param userPassword User Password.
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Gets the user name.
     * @return the user name.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the user name.
     * @param userName user's name.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the user birthdate.
     * Gets the sql date then convert into a String (Brazil Format).
     * @return User's birthdate.
     */
    public String getUserBirthdate() {
        LocalDate date = userBirthdate.toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    /**
     * Set the user birthdate.
     * Convert a String birthdate input to an sql date output.
     * This String need to come in format: yyyy-[m]m-[d]d (optional zeroes of months and days).
     * @param userBirthdate User's birthdate.
     */
    public void setUserBirthdate(String userBirthdate) {
        this.userBirthdate = Date.valueOf(userBirthdate);
    }

    /**
     * Gets the user height in centimeters.
     * @return user height (cm).
     */
    public short getUserHeight() {
        return userHeight;
    }

    /**
     * Set the user height value in centimeters.
     * @param userHeight user's height.
     */
    public void setUserHeight(short userHeight) {
        this.userHeight = userHeight;
    }

    /**
     * Gets the user gender.
     * (M)en or (W)omen - char value.
     * @return user gender.
     */
    public char getUserGender() {
        return userGender;
    }

    /**
     * Set the user gender (char value).
     * (M)en or (W)omen.
     * @param userGender user gender (M or W).
     */
    public void setUserGender(char userGender) {
        this.userGender = userGender;
    }

    /**
     * Gets the user phone number.
     * @return User phone number.
     */
    public long getUserPhone() {
        return userPhone;
    }

    /**
     * Set the user phone number.
     * @param userPhone user phone number.
     */
    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

}