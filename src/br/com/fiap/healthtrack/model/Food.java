package br.com.fiap.healthtrack.model;

import java.io.Serializable;

/**
 * Class that represents a food that can be present in a meal.
 * A food can be in many meals. A meal can have multiple foods.
 * A meal can not have any foods (totals entered manually).
 * @author Marcelo Portella
 * @version 0.1
 */
public class Food implements Serializable {

    /**
     * Food class objects version control.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Food ID.
     */
    private int idFood;

    /**
     * Food name and description.
     */
    private String dsFood;

    /**
     * Amount of weight (grams) present in a standard serving of food.
     * e.g. An egg have 30g. A medium beef have 100g.
     */
    private float nrGrPortion;

    /**
     * Approximate amount of calories (kcal) present in one gram of food.
     */
    private float nrKcalGr;

    /**
     * Approximate amount of carbohydrates present in one gram of food.
     */
    private float nrCarbGr;

    /**
     * Approximate amount of protein present in one gram of food.
     */
    private float nrProtGr;

    /**
     * Approximate amount of fat present in one gram of food.
     */
    private float nrFatGr;

    /**
     * Default constructor for the Food class.
     */
    public Food() {
    }


    // Getters & Setters
    public int getIdFood() {
		return idFood;
	}
	public void setIdFood(int idFood) {
		this.idFood = idFood;
	}
	public String getDsFood() {
		return dsFood;
	}
	public void setDsFood(String dsFood) {
		this.dsFood = dsFood;
	}
	public float getNrGrPortion() {
		return nrGrPortion;
	}
	public void setNrGrPortion(float nrGrPortion) {
		this.nrGrPortion = nrGrPortion;
	}
	public float getNrKcalGr() {
		return nrKcalGr;
	}
	public void setNrKcalGr(float nrKcalGr) {
		this.nrKcalGr = nrKcalGr;
	}
	public float getNrCarbGr() {
		return nrCarbGr;
	}
	public void setNrCarbGr(float nrCarbGr) {
		this.nrCarbGr = nrCarbGr;
	}
	public float getNrProtGr() {
		return nrProtGr;
	}
	public void setNrProtGr(float nrProtGr) {
		this.nrProtGr = nrProtGr;
	}
	public float getNrFatGr() {
		return nrFatGr;
	}
	public void setNrFatGr(float nrFatGr) {
		this.nrFatGr = nrFatGr;
	}


	@Override
    public String toString() {
        return "Food{" +
                "idFood=" + idFood +
                ", dsFood='" + dsFood + "'" +
                ", nrGrPortion=" + nrGrPortion +
                ", nrKcalGr=" + nrKcalGr +
                ", nrCarbGr=" + nrCarbGr +
                ", nrProtGr=" + nrProtGr +
                ", nrFatGr=" + nrFatGr +
                '}';
    }

}