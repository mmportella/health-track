package br.com.fiap.healthtrack.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Class that abstracts a physical activity performed by the user.
 * A user can perform various activity types throughout the day.
 * @author Marcelo Portella
 * @version 0.1
 */
public class Activity implements Serializable {

    /**
     * Activity class objects version control.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Activity date.
     */
    private Date dtActivity;

    /**
     * Activity's day count.
     */
    private byte nrActivity;
    
    /**
     * Activity duration in minutes.
     */
    private short nrDuration;

    /**
     * Total calories (kcal) burned in activity.
     */
    private short nrKcal;

    /**
     * Default constructor for the Activity class.
     */
    public Activity() {
    }

    private short kcalTotal(short nrDuration, int idActvType) {
    	short kcalTotal = 0;
    	ActvTypeDAO actv = new ActvTypeDAO;
    	short nrKcalHour = actv.getNrKcalHour(idActvType);
    	kcalTotal = (short) (nrKcalHour * nrDuration);
    	return kcalTotal;
    }
    
    
    // Getters & Setters
    public Date getDtActivity() {
		return dtActivity;
	}
	public void setDtActivity(Date dtActivity) {
		this.dtActivity = dtActivity;
	}
	public byte getNrActivity() {
		return nrActivity;
	}
	public void setNrActivity(byte nrActivity) {
		this.nrActivity = nrActivity;
	}
	public short getNrDuration() {
		return nrDuration;
	}
	public void setNrDuration(short nrDuration) {
		this.nrDuration = nrDuration;
	}
	public short getNrKcal() {
		return nrKcal;
	}
	public void setNrKcal(short nrDuration, int idActvType) {
		this.nrKcal = kcalTotal(nrDuration, idActvType);
	}

	
	@Override
    public String toString() {
        return "Activity{" +
                "dtActivity=" + dtActivity.toString() +
                ", nrActivity=" + nrActivity +
                ", nrDuration=" + nrDuration +
                ", nrKcal=" + nrKcal +
                '}';
    }
}