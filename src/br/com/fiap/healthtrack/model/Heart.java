package br.com.fiap.healthtrack.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Class that abstracts the user's heart health and pressure parameters.
 * The user can record all the informations about their heart once a day, and can modify it if necessary.
 * @author Marcelo Portella
 * @version 0.1
 */
public class Heart implements Serializable {

    /**
     * Heart class objects version control.
     */
    private static final long serialVersionUID = 1L;

    /**
     * User's heart information record date.
     */
    private Date dtHeart;

    /**
     * User's heart rate, in beats per minute.
     */
    private short nrBpm;

    /**
     * User's systolic pressure, in mmHg.
     */
    private short nrSystolic;

    /**
     * User's diastolic pressure, in mmHg.
     */
    private short nrDiastolic;

    /**
     * Default constructor for the Heart class.
     */
    public Heart(){
    }


    // Getters & Setters
    public Date getDtHeart() {
		return dtHeart;
	}
	public void setDtHeart(Date dtHeart) {
		this.dtHeart = dtHeart;
	}
	public short getNrBpm() {
		return nrBpm;
	}
	public void setNrBpm(short nrBpm) {
		this.nrBpm = nrBpm;
	}
	public short getNrSystolic() {
		return nrSystolic;
	}
	public void setNrSystolic(short nrSystolic) {
		this.nrSystolic = nrSystolic;
	}
	public short getNrDiastolic() {
		return nrDiastolic;
	}
	public void setNrDiastolic(short nrDiastolic) {
		this.nrDiastolic = nrDiastolic;
	}


	@Override
    public String toString() {
        return "Heart{" +
                "dtHeart=" + dtHeart.toString() +
                ", nrBpm=" + nrBpm +
                ", nrSystolic=" + nrSystolic +
                ", nrDiastolic=" + nrDiastolic +
                '}';
    }
	
}