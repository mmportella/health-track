package com.healthtrack.dao;

import com.healthtrack.model.PhysicalExercise;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class PhysicalExerciseDAO implements IPhysicalExerciseDAO {
    @Override
    public void create(PhysicalExercise physicalExercise) throws SQLException {

    }

    @Override
    public List<PhysicalExercise> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<PhysicalExercise> getByDate(Calendar exerciseDate) throws SQLException {
        return null;
    }

    @Override
    public void update(PhysicalExercise physicalExercise) throws SQLException {

    }

    @Override
    public void delete(Calendar exerciseDate) throws SQLException {

    }
}