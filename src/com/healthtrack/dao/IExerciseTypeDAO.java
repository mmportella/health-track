package com.healthtrack.dao;

import com.healthtrack.model.ExerciseType;

import java.sql.SQLException;
import java.util.List;

public interface IExerciseTypeDAO {

    void create(ExerciseType exerciseType) throws SQLException;

    List<ExerciseType> getAll() throws SQLException;

    List<ExerciseType> getByDescription(String exTypeDescription) throws SQLException;

    void update(ExerciseType exerciseType) throws SQLException;

    void delete(int exTypeId) throws SQLException;

}