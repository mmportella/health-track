package com.healthtrack.model;

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
    private int foodId;

    /**
     * Food name and description.
     */
    private String foodDescription;

    /**
     * Amount of weight (grams) present in a standard serving of food.
     * e.g. An egg have 30g. A medium beef have 100g.
     */
    private float gramsPerPortion;

    /**
     * Approximate amount of calories (kcal) present in one gram of food.
     */
    private float kcalPerGram;

    /**
     * Approximate amount of carbohydrates present in one gram of food.
     */
    private float carbPerGram;

    /**
     * Approximate amount of protein present in one gram of food.
     */
    private float protPerGram;

    /**
     * Approximate amount of fat present in one gram of food.
     */
    private float fatPerGram;

    /**
     * Default constructor for the Food class.
     */
    public Food() {
    }

    /**
     * Get the food ID number.
     * @return Food ID.
     */
    public int getFoodId() {
        return foodId;
    }

    /**
     * Set the food ID number.
     * @param foodId Food ID.
     */
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    /**
     * Get food name and description.
     * @return Food name and description.
     */
    public String getFoodDescription() {
        return foodDescription;
    }

    /**
     * Set food name and description.
     * @param foodDescription Food name and description.
     */
    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    /**
     * Get the amount of weight (grams) present in a standard serving of food.
     * @return Weight (grams).
     */
    public float getGramsPerPortion() {
        return gramsPerPortion;
    }

    /**
     * Set the amount of weight (grams) present in a standard serving of food.
     * @param gramsPerPortion Weight (grams).
     */
    public void setGramsPerPortion(float gramsPerPortion) {
        this.gramsPerPortion = gramsPerPortion;
    }

    /**
     * Get calories (kcal) per gram of food value.
     * @return Calories (kcal) per gram of food.
     */
    public float getKcalPerGram() {
        return kcalPerGram;
    }

    /**
     * Set calories (kcal) per gram of food value.
     * @param kcalPerGram Calories (kcal) per gram of food.
     */
    public void setKcalPerGram(float kcalPerGram) {
        this.kcalPerGram = kcalPerGram;
    }

    /**
     * Get carbohydrates per gram of food value.
     * @return Carbohydrates per gram of food.
     */
    public float getCarbPerGram() {
        return carbPerGram;
    }

    /**
     * Set carbohydrates per gram of food value.
     * @param carbPerGram Carbohydrates per gram of food.
     */
    public void setCarbPerGram(float carbPerGram) {
        this.carbPerGram = carbPerGram;
    }

    /**
     * Get protein per gram of food value.
     * @return Protein per gram of food.
     */
    public float getProtPerGram() {
        return protPerGram;
    }

    /**
     * Set protein per gram of food value.
     * @param protPerGram Protein per gram of food.
     */
    public void setProtPerGram(float protPerGram) {
        this.protPerGram = protPerGram;
    }

    /**
     * Get fat per gram of food value.
     * @return Fat per gram of food.
     */
    public float getFatPerGram() {
        return fatPerGram;
    }

    /**
     * Set fat per gram of food value.
     * @param fatPerGram Fat per gram of food.
     */
    public void setFatPerGram(float fatPerGram) {
        this.fatPerGram = fatPerGram;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", foodDescription='" + foodDescription + "'" +
                ", gramsPerPortion=" + gramsPerPortion +
                ", kcalPerGram=" + kcalPerGram +
                ", carbPerGram=" + carbPerGram +
                ", protPerGram=" + protPerGram +
                ", fatPerGram=" + fatPerGram +
                '}';
    }

}