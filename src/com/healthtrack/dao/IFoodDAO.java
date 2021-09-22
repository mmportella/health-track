package com.healthtrack.dao;

import com.healthtrack.model.Food;
import java.sql.SQLException;
import java.util.List;

public interface IFoodDAO {

    void create(Food food) throws SQLException;

    List<Food> getAll() throws SQLException;

    List<Food> getByDescription(String foodDescription) throws SQLException;

    void update(Food food) throws SQLException;

    void delete(int foodId) throws SQLException;

}