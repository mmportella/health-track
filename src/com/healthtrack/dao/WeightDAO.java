package com.healthtrack.dao;

import com.healthtrack.model.Weight;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WeightDAO implements IWeightDAO {

    List<Weight> list = new ArrayList<>();

    @Override
    public void create(Weight weight) throws SQLException {
        list.add(weight);
    }

    @Override
    public List<Weight> getAll() throws SQLException {
        return list;
    }

    @Override
    public Weight getByDate(Calendar weightDate) throws SQLException {
        return null;
    }

    @Override
    public void update(Weight weight) throws SQLException {
    }

    @Override
    public void delete(Calendar weightDate) throws SQLException {
    }

}