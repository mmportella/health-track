package com.healthtrack.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// Como dica eu faria apenas uma relação entre as classes Alimentação e Alimento. Poderíamos ter dentro de Alimentação um objeto do tipo Alimento.

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
    private Calendar mealDate;

    /**
     * Meal code.
     * A (Breakfast), B (Launch), C (Dinner), D (Other meals).
     */
    private char mealType;

    /**
     * Meal total calories (kcal).
     */
    private float mealKcal;

    /**
     * Meal notes.
     */
    private String mealNotes;

    /**
     * Class default constructor.
     */
    public Meal() {
    }

    /**
     * Gets meal date.
     * @return meal date.
     */
    public Calendar getMealDate() {
        return mealDate;
    }

    /**
     * Set the meal date.
     */
    public void setMealDate(Calendar mealDate) {
        this.mealDate = mealDate;
    }

    /**
     * Gets the meal type code.
     * A (Breakfast), B (Launch), C (Dinner), D (Other meals).
     * @return Meal code.
     */
    public char getMealType() {
        return mealType;
    }
    /**
     * Set the meal type code (char value).
     * A (Breakfast), B (Launch), C (Dinner), D (Other meals).
     * @param mealType meal type code.
     */
    public void setMealType(char mealType) {
        this.mealType = mealType;
    }

    /**
     * Gets the total calories from the meal.
     * @return total calories (kcal).
     */
    public float getMealKcal() {
        return mealKcal;
    }
    /**
     * Sets the total calories from the meal.
     * @param mealKcal total calories (kcal).
     */
    public void setMealKcal(float mealKcal) {
        this.mealKcal = mealKcal;
    }

    /**
     * Gets the meal notes.
     * @return meal notes.
     */
    public String getMealNotes() {
        return mealNotes;
    }
    /**
     * Sets the meal notes.
     * @param mealNotes meal notes.
     */
    public void setMealNotes(String mealNotes) {
        this.mealNotes = mealNotes;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Meal{" +
                "mealDate=" + sdf.format(mealDate.getTime()) +
                ", mealType=" + mealType +
                ", mealKcal=" + mealKcal +
                ", mealNotes='" + mealNotes + "'" +
                '}';
    }
}