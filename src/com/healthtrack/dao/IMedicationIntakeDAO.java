package com.healthtrack.dao;

import com.healthtrack.model.MedicationIntake;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public interface IMedicationIntakeDAO {

    void create(MedicationIntake medicationIntake) throws SQLException;

    List<MedicationIntake> getAll() throws SQLException;

    List<MedicationIntake> getByDate(Calendar medDate) throws SQLException;

    void update(MedicationIntake medicationIntake) throws SQLException;

    void delete(Calendar medDate) throws SQLException;

}