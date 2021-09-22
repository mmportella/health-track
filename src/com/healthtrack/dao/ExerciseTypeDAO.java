package com.healthtrack.dao;

import com.healthtrack.model.ExerciseType;

import java.sql.SQLException;
import java.util.List;

public class ExerciseTypeDAO implements IExerciseTypeDAO {
    @Override
    public void create(ExerciseType exerciseType) throws SQLException {

    }

    @Override
    public List<ExerciseType> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<ExerciseType> getByDescription(String exTypeDescription) throws SQLException {
        return null;
    }

    @Override
    public void update(ExerciseType exerciseType) throws SQLException {

    }

    @Override
    public void delete(int exTypeId) throws SQLException {

    }
}