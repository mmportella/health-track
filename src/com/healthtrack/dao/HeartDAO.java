package com.healthtrack.dao;

import com.healthtrack.model.Heart;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class HeartDAO implements IHeartDAO {
    @Override
    public void create(Heart heart) throws SQLException {

    }

    @Override
    public List<Heart> getAll() throws SQLException {
        return null;
    }

    @Override
    public Heart getByDate(Calendar heartDate) throws SQLException {
        return null;
    }

    @Override
    public void update(Heart heart) throws SQLException {

    }

    @Override
    public void delete(Calendar heartDate) throws SQLException {

    }
}