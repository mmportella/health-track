package com.healthtrack.dao;

import com.healthtrack.model.MedicationIntake;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class MedicationIntakeDAO implements IMedicationIntakeDAO {
    @Override
    public void create(MedicationIntake medicationIntake) throws SQLException {

    }

    @Override
    public List<MedicationIntake> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<MedicationIntake> getByDate(Calendar medDate) throws SQLException {
        return null;
    }

    @Override
    public void update(MedicationIntake medicationIntake) throws SQLException {

    }

    @Override
    public void delete(Calendar medDate) throws SQLException {

    }
}