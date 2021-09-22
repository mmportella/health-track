package com.healthtrack.dao;

import com.healthtrack.model.PhysicalExercise;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public interface IPhysicalExerciseDAO {

    void create(PhysicalExercise physicalExercise) throws SQLException;

    List<PhysicalExercise> getAll() throws SQLException;

    List<PhysicalExercise> getByDate(Calendar exerciseDate) throws SQLException;

    void update(PhysicalExercise physicalExercise) throws SQLException;

    void delete(Calendar exerciseDate) throws SQLException;

}