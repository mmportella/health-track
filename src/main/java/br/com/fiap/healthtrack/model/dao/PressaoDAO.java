package br.com.fiap.healthtrack.model.dao;

import br.com.fiap.healthtrack.model.beans.Pressao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PressaoDAO {
	
	public List<Pressao> getAll(long id) {
		List<Pressao> listaPressao = new ArrayList<Pressao>();
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_PRESSAO WHERE USUARIO_ID_USUARIO = ? ORDER BY DT_MEDICAO DESC");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Pressao medicao = new Pressao();
				long idPressao = rs.getLong("ID_PRESSAO");
				medicao.setIdPressao(idPressao);
				short sistolica = rs.getShort("PRESSAO_SISTOLICA");
				medicao.setPressaoSistolica(sistolica);
				short diastolica = rs.getShort("PRESSAO_DIASTOLICA");
				medicao.setPressaoDiastolica(diastolica);
				java.sql.Date sqlDate = rs.getDate("DT_MEDICAO");
				int dia = sqlDate.toLocalDate().getDayOfMonth();
				int mes = sqlDate.toLocalDate().getMonthValue();
				int ano = sqlDate.toLocalDate().getYear();
				String dataPressao = dia + "/" + mes + "/" + ano;
				medicao.setDataPressao(dataPressao);
				listaPressao.add(medicao);
			}
			rs.close();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaPressao;
	}
	
	
	public Pressao getById(long id) {
		Pressao pressao = new Pressao();
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_PRESSAO WHERE ID_PRESSAO = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				long idPressao = rs.getLong("ID_PRESSAO");
				pressao.setIdPressao(idPressao);
				short sistolica = rs.getShort("PRESSAO_SISTOLICA");
				pressao.setPressaoSistolica(sistolica);
				short diastolica = rs.getShort("PRESSAO_DIASTOLICA");
				pressao.setPressaoDiastolica(diastolica);
				java.sql.Date sqlDate = rs.getDate("DT_MEDICAO");
				int diaInt = sqlDate.toLocalDate().getDayOfMonth();
				String dia = String.valueOf(diaInt);
				if (diaInt <= 9) {
					dia = "0" + dia;
				}
				int mesInt = sqlDate.toLocalDate().getMonthValue();
				String mes = String.valueOf(mesInt);
				if (mesInt <= 9) {
					mes = "0" + mes;
				}
				int ano = sqlDate.toLocalDate().getYear();
				String dataPressao = ano + "-" + mes + "-" + dia;
				pressao.setDataPressao(dataPressao);
			}
			rs.close();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pressao;
	}
	
	public short getLastSistolica(long id) {
		short sistolica = 0;
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("SELECT PRESSAO_SISTOLICA FROM T_PRESSAO WHERE USUARIO_ID_USUARIO = ? ORDER BY DT_MEDICAO DESC");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				sistolica = rs.getShort("PRESSAO_SISTOLICA");
			}
			rs.close();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sistolica;
	}
	
	
	public short getLastDiastolica(long id) {
		short diastolica = 0;
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("SELECT PRESSAO_DIASTOLICA FROM T_PRESSAO WHERE USUARIO_ID_USUARIO = ? ORDER BY DT_MEDICAO DESC");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				diastolica = rs.getShort("PRESSAO_DIASTOLICA");
			}
			rs.close();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diastolica;
	}
	
	
	public int add(long id, Pressao pressao) {
		Connection conexao = ConnectionManager.getInstance().getConnection();
		try {
			PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_PRESSAO (ID_PRESSAO, PRESSAO_SISTOLICA, PRESSAO_DIASTOLICA, DT_MEDICAO, USUARIO_ID_USUARIO) "
															+ "VALUES (SEQ_PRESSAO.nextval, ?, ?, ?, ?)");
			stmt.setShort(1, pressao.getPressaoSistolica());
			stmt.setShort(2, pressao.getPressaoDiastolica());
			stmt.setDate(3, java.sql.Date.valueOf(pressao.getDataPressao()));
			stmt.setLong(4, id);
			stmt.executeUpdate();
			conexao.commit();
			stmt.close();
			conexao.close();
			return 1;
		} catch (SQLException e) {
			try {
				conexao.rollback();
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int update(Pressao pressao) {
		Connection conexao = ConnectionManager.getInstance().getConnection();
		try {
			PreparedStatement stmt = conexao.prepareStatement("UPDATE T_PRESSAO SET PRESSAO_SISTOLICA = ?, PRESSAO_DIASTOLICA = ?, DT_MEDICAO = ? WHERE ID_PRESSAO = ?");
			stmt.setShort(1, pressao.getPressaoSistolica());
			stmt.setShort(2, pressao.getPressaoDiastolica());
			stmt.setDate(3, java.sql.Date.valueOf(pressao.getDataPressao()));
			stmt.setLong(4, pressao.getIdPressao());
			stmt.executeUpdate();
				conexao.commit();
				stmt.close();
				conexao.close();
				return 1;
		} catch (SQLException e) {
			try {
				conexao.rollback();
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int delete(long id) {
		Connection conexao = ConnectionManager.getInstance().getConnection();
		try {
			PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_PRESSAO WHERE ID_PRESSAO = ?");
			stmt.setLong(1, id);
			stmt.executeUpdate();
			conexao.commit();
			stmt.close();
			conexao.close();
			return 1;
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
