package com.healthtrack.dao;

import com.healthtrack.model.Meal;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public interface IMealDAO {

    void create(Meal meal) throws SQLException;

    List<Meal> getAll() throws SQLException;

    List<Meal> getByDate(Calendar meaDate) throws SQLException;

    void update(Meal meal) throws SQLException;

    void delete(Calendar mealDate) throws SQLException;

}