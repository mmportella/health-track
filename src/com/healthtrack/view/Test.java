package com.healthtrack.view;

import com.healthtrack.dao.WeightDAO;
import com.healthtrack.model.Weight;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {

        WeightDAO dao = new WeightDAO();

        for (int i = 0; i < 10; i++) {
            Calendar cal = Calendar.getInstance();
            cal.set(2021,8,1+i);
            Weight obj = new Weight(cal, 89.0f-i, 26.0f-i, 38.0f+(i/2), 8.0f-(i/4));
            dao.create(obj);
        }

        List<Weight> lista = dao.getAll();

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }

    }
}