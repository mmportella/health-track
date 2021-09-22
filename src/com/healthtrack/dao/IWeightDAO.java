package com.healthtrack.dao;

import com.healthtrack.model.Weight;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public interface IWeightDAO {

    void create(Weight weight) throws SQLException;

    List<Weight> getAll() throws SQLException;

    Weight getByDate(Calendar weightDate) throws SQLException;

    void update(Weight weight) throws SQLException;

    void delete(Calendar weightDate) throws SQLException;

}