package com.healthtrack.dao;

import com.healthtrack.model.Medication;

import java.sql.SQLException;
import java.util.List;

public class MedicationDAO implements IMedicationDAO {
    @Override
    public void create(Medication medication) throws SQLException {

    }

    @Override
    public List<Medication> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<Medication> getByName(String medName) throws SQLException {
        return null;
    }

    @Override
    public void update(Medication medication) throws SQLException {

    }

    @Override
    public void delete(int medId) throws SQLException {

    }
}