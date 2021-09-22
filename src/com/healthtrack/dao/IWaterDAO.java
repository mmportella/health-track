package com.healthtrack.dao;

import com.healthtrack.model.Water;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public interface IWaterDAO {

    void create(Water water) throws SQLException;

    List<Water> getAll() throws SQLException;

    List<Water> getByDate(Calendar waterDate) throws SQLException;

    void update(Water water) throws SQLException;

    void delete(Calendar waterDate) throws SQLException;

}