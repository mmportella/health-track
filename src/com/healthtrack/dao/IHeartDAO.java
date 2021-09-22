package com.healthtrack.dao;

import com.healthtrack.model.Heart;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public interface IHeartDAO {

    void create(Heart heart) throws SQLException;

    List<Heart> getAll() throws SQLException;

    Heart getByDate(Calendar heartDate) throws SQLException;

    void update(Heart heart) throws SQLException;

    void delete(Calendar heartDate) throws SQLException;

}