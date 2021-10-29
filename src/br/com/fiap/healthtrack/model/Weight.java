package br.com.fiap.healthtrack.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Class that abstracts the user's Weight and Body Composition information (WBC) on a given date.
 * A user can record WBC once a day and can change or delete it.
 * While recording his weight, user can or can not record his corporal composition information.
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
    private Date dtWeight;
    
    /**
     * User weight in kilograms.
     */
    private float nrWeight;
    
    /**
     * User's body fat percentage.
     */
    private float nrBodyfat;
    
    /**
     * User's skeletal muscle percentage.
     */
    private float nrMuscle;
    
    /**
     * User's visceral fat percentage.
     */
    private float nrVisceral;

    /**
     * Weight class default constructor.
     */
    public Weight() {
    }

    
    // Getters & Setters
    public Date getDtWeight() {
		return dtWeight;
	}
	public void setDtWeight(Date dtWeight) {
		this.dtWeight = dtWeight;
	}
	public float getNrWeight() {
		return nrWeight;
	}
	public void setNrWeight(float nrWeight) {
		this.nrWeight = nrWeight;
	}
	public float getNrBodyfat() {
		return nrBodyfat;
	}
	public void setNrBodyfat(float nrBodyfat) {
		this.nrBodyfat = nrBodyfat;
	}
	public float getNrMuscle() {
		return nrMuscle;
	}
	public void setNrMuscle(float nrMuscle) {
		this.nrMuscle = nrMuscle;
	}
	public float getNrVisceral() {
		return nrVisceral;
	}
	public void setNrVisceral(float nrVisceral) {
		this.nrVisceral = nrVisceral;
	}


	/**
     * Get the WBC object attributes information (String format).
     * @return WBC object.
     */
    @Override
    public String toString() {
        return "Weight{" +
                "dtWeight=" + dtWeight.toString() +
                ", nrWeight=" + nrWeight +
                ", nrBodyfat=" + nrBodyfat +
                ", nrMuscle=" + nrMuscle +
                ", nrVisceral=" + nrVisceral +
                '}';
    }

}