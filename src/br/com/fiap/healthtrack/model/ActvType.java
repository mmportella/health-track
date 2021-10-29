package br.com.fiap.healthtrack.model;

import java.io.Serializable;

/**
 * Class that abstracts a type of physical activity that the user can perform.
 * An activity type can be realized many times, many days by the user.
 * An activity type can be entered into the database at the time of physical activity recording.
 * So a type of physical activity only exists if a user has already done it at least once.
 * @author Marcelo Portella
 * @version 0.1
 */
public class ActvType implements Serializable {

    /**
     * ActvType class objects version control.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Activity type ID number.
     */
    private int idActvType;

    /**
     * Activity type name and description.
     */
    private String dsActvType;

    /**
     * Calories burned (kcal) per minute of this activity type.
     */
    private short nrKcalHour;

    /**
     * Default constructor for the Food class.
     */
    public ActvType() {
    }


    // Getters & Setters
    public int getIdActvType() {
		return idActvType;
	}
	public void setIdActvType(int idActvType) {
		this.idActvType = idActvType;
	}
	public String getDsActvType() {
		return dsActvType;
	}
	public void setDsActvType(String dsActvType) {
		this.dsActvType = dsActvType;
	}
	public float getNrKcalHour() {
		return nrKcalHour;
	}
	public void setNrKcalHour(short nrKcalHour) {
		this.nrKcalHour = nrKcalHour;
	}


	@Override
	public String toString() {
        return "ActvType{" +
                "idActvType=" + idActvType +
                ", exTypeDescription='" + dsActvType + "'" +
                ", nrKcalHour=" + nrKcalHour +
                '}';
    }

}