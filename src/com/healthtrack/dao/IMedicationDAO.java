package com.healthtrack.dao;

import com.healthtrack.model.Medication;

import java.sql.SQLException;
import java.util.List;

public interface IMedicationDAO {

    void create(Medication medication) throws SQLException;

    List<Medication> getAll() throws SQLException;

    List<Medication> getByName(String medName) throws SQLException;

    void update(Medication medication) throws SQLException;

    void delete(int medId) throws SQLException;

}