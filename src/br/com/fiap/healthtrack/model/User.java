package br.com.fiap.healthtrack.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Class that represents a user of the Health Track system.
 * A user can record various types of information about their health.
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
    private int idUser;
    
    /**
     * User email.
     */
    private String dsEmail;
    
    /**
     * User password.
     */
    private String dsPassword;
    
    /**
     * User name.
     */
    private String dsName;
    
    /**
     * User birthdate.
     */
    private Date dtBirthdate;
    
    /**
     * User height (cm).
     */
    private short nrHeight;

    /**
     * User gender (M or F).
     */
    private char dsGender;
    
    /**
     * User class default constructor.
     */
    public User(){
    }
    
    
    // Getters & Setters

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsPassword() {
		return dsPassword;
	}

	public void setDsPassword(String dsPassword) {
		this.dsPassword = dsPassword;
	}

	public String getDsName() {
		return dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public Date getDtBirthdate() {
		return dtBirthdate;
	}

	public void setDtBirthdate(Date dtBirthdate) {
		this.dtBirthdate = dtBirthdate;
	}

	public short getNrHeight() {
		return nrHeight;
	}

	public void setNrHeight(short nrHeight) {
		this.nrHeight = nrHeight;
	}

	public char getDsGender() {
		return dsGender;
	}

	public void setDsGender(char dsGender) {
		this.dsGender = dsGender;
	}
	
}