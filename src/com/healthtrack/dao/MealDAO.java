package com.healthtrack.dao;

import com.healthtrack.model.Meal;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class MealDAO implements IMealDAO {
    @Override
    public void create(Meal meal) throws SQLException {

    }

    @Override
    public List<Meal> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<Meal> getByDate(Calendar meaDate) throws SQLException {
        return null;
    }

    @Override
    public void update(Meal meal) throws SQLException {

    }

    @Override
    public void delete(Calendar mealDate) throws SQLException {

    }
}