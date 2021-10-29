package br.com.fiap.healthtrack.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Class that represents a meal eaten by user.
 * A user can have as many meals as he wants a day and can change or delete it.
 * A meal can have multiple foods. A meal can not have any foods (totals entered manually).
 * @author Marcelo Portella
 * @version 0.1
 */
public class Meal implements Serializable {

    /**
     * Meal class objects version control.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Meal date.
     */
    private Date dtMeal;

    /**
     * Meal's number in day.
     */
    private byte nrMeal;

    /**
     * Meal name.
     */
    private String dsMeal;
    
    /**
     * Meal total calories (kcal).
     */
    private short nrKcal;
    
    /**
     * Meal total carbs (g).
     */
    private float nrCarb;
    
    /**
     * Meal total proteins (g).
     */
    private float nrProt;
    
    /**
     * Meal total fats (g).
     */
    private float nrFat;
    
    /**
     * Class default constructor.
     */
    public Meal() {
    }


    private short kcalTotal(int idFood, int qtConsumed) {
    	short kcalTotal = 0;
    	FoodDAO food = new FoodDAO;
    	float nrKcalGr = food.getNrKcalGr(idFood);
    	kcalTotal = (short) (nrKcalGr * qtConsumed);
    	return kcalTotal;
    }
    
    private float carbTotal(int idFood, float qtConsumed) {
    	float carbTotal = 0.0f;
    	FoodDAO food = new FoodDAO;
    	int nrCarbGr = food.getNrCarbGr(idFood);
    	carbTotal = nrCarbGr * qtConsumed;
    	return carbTotal;
    }
    
    private float protTotal(int idFood, float qtConsumed) {
    	float protTotal = 0.0f;
    	FoodDAO food = new FoodDAO;
    	int nrProtGr = food.getNrProtGr(idFood);
    	protTotal = nrProtGr * qtConsumed;
    	return protTotal;
    }
    
    private float fatTotal(int idFood, float qtConsumed) {
    	float fatTotal = 0.0f;
    	FoodDAO food = new FoodDAO;
    	int nrFatGr = food.getNrFatGr(idFood);
    	fatTotal = nrFatGr * qtConsumed;
    	return fatTotal;
    }
    
    
    // Getters & Setters
    public Date getDtMeal() {
		return dtMeal;
	}
	public void setDtMeal(Date dtMeal) {
		this.dtMeal = dtMeal;
	}
	public byte getNrMeal() {
		return nrMeal;
	}
	public void setNrMeal(byte nrMeal) {
		this.nrMeal = nrMeal;
	}
	public String getDsMeal() {
		return dsMeal;
	}
	public void setDsMeal(String dsMeal) {
		this.dsMeal = dsMeal;
	}
	public float getNrKcal() {
		return nrKcal;
	}
	public void setNrKcal(int idFood, int qtConsumed) {
		this.nrKcal = kcalTotal(idFood,qtConsumed);
	}
	public float getNrCarb() {
		return nrCarb;
	}
	public void setNrCarb(int idFood, float qtConsumed) {
		this.nrCarb = carbTotal(idFood,qtConsumed);
	}
	public float getNrProt() {
		return nrProt;
	}
	public void setNrProt(int idFood, float qtConsumed) {
		this.nrProt = protTotal(idFood,qtConsumed);
	}
	public float getNrFat() {
		return nrFat;
	}
	public void setNrFat(int idFood, float qtConsumed) {
		this.nrFat = fatTotal(idFood,qtConsumed);
	}


	@Override
    public String toString() {
        return "Meal{" +
                "dtMeal=" + dtMeal.toString() +
                ", nrMeal=" + nrMeal +
                ", dsMeal='" + dsMeal + "'" +
                ", nrKcal=" + nrKcal +
                ", nrCarb=" + nrCarb +
                ", nrProt=" + nrProt +
                ", nrFat=" + nrFat +
                '}';
    }
}