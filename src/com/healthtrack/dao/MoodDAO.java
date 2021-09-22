package com.healthtrack.dao;

import com.healthtrack.model.Mood;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class MoodDAO implements IMoodDAO {
    @Override
    public void create(Mood mood) throws SQLException {

    }

    @Override
    public List<Mood> getAll() throws SQLException {
        return null;
    }

    @Override
    public Mood getByDate(Calendar moodDate) throws SQLException {
        return null;
    }

    @Override
    public void update(Mood mood) throws SQLException {

    }

    @Override
    public void delete(Calendar moodDate) throws SQLException {

    }
}