package com.healthtrack.dao;

import com.healthtrack.model.Food;

import java.sql.SQLException;
import java.util.List;

public class FoodDAO implements IFoodDAO {
    @Override
    public void create(Food food) throws SQLException {

    }

    @Override
    public List<Food> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<Food> getByDescription(String foodDescription) throws SQLException {
        return null;
    }

    @Override
    public void update(Food food) throws SQLException {

    }

    @Override
    public void delete(int foodId) throws SQLException {

    }
}