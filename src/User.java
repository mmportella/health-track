import java.io.Serializable;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
     * Encrypt the user's password with SHA-256.
     * Adds the user ID before password to change the hash.
     * @param userPassword the user's password.
     * @return the password hash.
     * @throws NoSuchAlgorithmException No algorithm exception.
     */
    private String hashing (String userPassword) throws NoSuchAlgorithmException {
        Integer id = this.userId;
        String stringPass = id.toString() + userPassword;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(stringPass.getBytes(StandardCharsets.UTF_8));
        return new String(hash, StandardCharsets.UTF_8);
    }

    /**
     * Authenticate the user login information.
     * @param userEmail user e-mail.
     * @param userPassword user password.
     * @return boolean value (user authenticated or not).
     * @throws NoSuchAlgorithmException No algorithm exception.
     */
    public boolean login(String userEmail, String userPassword) throws NoSuchAlgorithmException {
        String hashedPass = this.userPassword; // Next versions this will come from database.
        return userEmail.equals(this.userEmail) && hashing(userPassword).equals(hashedPass);
    }

    /**
     * Sets the user password (hash).
     * Uses hashing() method to encrypt the password with SHA-256.
     * @param userPassword User Password.
     * @throws NoSuchAlgorithmException No algorithm exception.
     */
    public void setUserPassword(String userPassword) throws NoSuchAlgorithmException {
        this.userPassword = hashing(userPassword);
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
