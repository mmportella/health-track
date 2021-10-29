package br.com.fiap.healthtrack.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.healthtrack.model.Weight;

public class WeightDAO {

	
	public List<Weight> getAll() {
		DAO dao = new DAO();
		List<Weight> listWeight = new ArrayList<Weight>();
		try {
			PreparedStatement stmt = dao.getConnection().prepareStatement("SELECT * FROM T_HLT_WEIGHT");
			ResultSet result = dao.getData(stmt);
			stmt.close();
			while (result.next()) {
				Weight w = new Weight();
				w.setDtWeight(result.getDate("DT_WEIGHT"));
				w.setNrWeight(result.getFloat("NR_WEIGHT"));
				w.setNrBodyfat(result.getFloat("NR_BODYFAT"));
				w.setNrMuscle(result.getFloat("NR_MUSCLE"));
				w.setNrVisceral(result.getFloat("NR_VISCERAL"));
				listWeight.add(w);
			}
			result.close();
			return listWeight;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Weight getByDate(String stringDate) {
		Date sqlDate = Date.valueOf(stringDate);
		DAO dao = new DAO();
		Weight weight = new Weight();
		weight.setNrWeight(0.0f);
		try {
			PreparedStatement stmt = dao.getConnection().prepareStatement("SELECT * FROM T_HLT_WEIGHT WHERE DT_WEIGHT = ?");
			stmt.setDate(1, sqlDate);
			ResultSet result = dao.getData(stmt);
			stmt.close();
			if (result.next()) {
				weight.setDtWeight(result.getDate("DT_WEIGHT"));
				weight.setNrWeight(result.getFloat("NR_WEIGHT"));
				weight.setNrBodyfat(result.getFloat("NR_BODYFAT"));
				weight.setNrMuscle(result.getFloat("NR_MUSCLE"));
				weight.setNrVisceral(result.getFloat("NR_VISCERAL"));
			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weight;
	}


	public int add(Weight obj) {
		DAO dao = new DAO();
		if (obj.getNrWeight() > 0.0f) {
			try {
				PreparedStatement stmt = dao.getConnection().prepareStatement("INSERT INTO T_HLT_WEIGHT VALUES (?, ?, ?, ?, ?)");
				stmt.setDate(1, obj.getDtWeight());
				stmt.setFloat(2, obj.getNrWeight());
				stmt.setFloat(3, obj.getNrBodyfat());
				stmt.setFloat(4, obj.getNrMuscle());
				stmt.setFloat(5, obj.getNrVisceral());
				int retorn = dao.executeCommand(stmt);
				stmt.close();
				return retorn;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}


	public int delete(String stringDate) {
		try {
			Date sqlDate = Date.valueOf(stringDate);
			DAO dao = new DAO();
			PreparedStatement stmt = dao.getConnection().prepareStatement("DELETE FROM T_HLT_WEIGHT WHERE DT_WEIGHT = ?");
			stmt.setDate(1, sqlDate);
			return dao.executeCommand(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	public int update(Weight obj) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.getConnection().prepareStatement("UPDATE T_HLT_WEIGHT SET DT_WEIGHT = ?, NR_WEIGHT = ?, NR_BODYFAT = ?, NR_MUSCLE = ?, "
																		+ "NR_VISCERAL = ? WHERE DT_WEIGHT = ?");
			stmt.setDate(1, obj.getDtWeight());
			stmt.setFloat(2, obj.getNrWeight());
			stmt.setFloat(3, obj.getNrBodyfat());
			stmt.setFloat(4, obj.getNrMuscle());
			stmt.setFloat(5, obj.getNrVisceral());
			stmt.setDate(6, obj.getDtWeight());
			int retorn = dao.executeCommand(stmt);
			stmt.close();
			return retorn;	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
}