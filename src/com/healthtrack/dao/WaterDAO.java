package com.healthtrack.dao;

import com.healthtrack.model.Water;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class WaterDAO implements IWaterDAO {
    @Override
    public void create(Water water) throws SQLException {

    }

    @Override
    public List<Water> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<Water> getByDate(Calendar waterDate) throws SQLException {
        return null;
    }

    @Override
    public void update(Water water) throws SQLException {

    }

    @Override
    public void delete(Calendar waterDate) throws SQLException {

    }

}