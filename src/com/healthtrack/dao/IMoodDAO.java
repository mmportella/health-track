package com.healthtrack.dao;

import com.healthtrack.model.Mood;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public interface IMoodDAO {

    void create(Mood mood) throws SQLException;

    List<Mood> getAll() throws SQLException;

    Mood getByDate(Calendar moodDate) throws SQLException;

    void update(Mood mood) throws SQLException;

    void delete(Calendar moodDate) throws SQLException;

}