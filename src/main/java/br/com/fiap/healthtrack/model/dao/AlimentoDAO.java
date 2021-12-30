package br.com.fiap.healthtrack.model.dao;

import br.com.fiap.healthtrack.model.beans.Alimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlimentoDAO {
	
	public List<Alimento> getAll(long id) {
		List<Alimento> listaAlimento = new ArrayList<Alimento>();
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_ALIMENTO WHERE USUARIO_ID_USUARIO = ? ORDER BY DT_ALIMENTO DESC");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Alimento refeicao = new Alimento();
				long idAlimento = rs.getLong("ID_ALIMENTO");
				refeicao.setIdAlimento(idAlimento);
				java.sql.Timestamp sqlDate = rs.getTimestamp("DT_ALIMENTO");
				int dia = sqlDate.toLocalDateTime().getDayOfMonth();
				int mes = sqlDate.toLocalDateTime().getMonthValue();
				int ano = sqlDate.toLocalDateTime().getYear();
				String dataAlimento = dia + "/" + mes + "/" + ano;
				refeicao.setDataAlimento(dataAlimento);
				int hora = sqlDate.toLocalDateTime().getHour();
				int minuto = sqlDate.toLocalDateTime().getMinute();
				String horaAlimento = hora + ":" + minuto;
				if (minuto <= 9) {
					horaAlimento = hora + ":0" + minuto;
				}
				refeicao.setHoraAlimento(horaAlimento);
				String categoria = rs.getString("CATEGORIA");
				refeicao.setCategoria(categoria);
				short kcal = rs.getShort("KCAL");
				refeicao.setKcal(kcal);
				String descricao = rs.getString("DESCRICAO");
				refeicao.setDescricao(descricao);
				listaAlimento.add(refeicao);
			}
			rs.close();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAlimento;
	}
	
	
	public Alimento getById(long id) {
		Alimento alimento = new Alimento();
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_ALIMENTO WHERE ID_ALIMENTO = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				long idAlimento = rs.getLong("ID_ALIMENTO");
				alimento.setIdAlimento(idAlimento);
				java.sql.Timestamp sqlDate = rs.getTimestamp("DT_ALIMENTO");
				
				int diaInt = sqlDate.toLocalDateTime().getDayOfMonth();
				String dia = String.valueOf(diaInt);
				if (diaInt <= 9) {
					dia = "0" + dia;
				}
				
				int mesInt = sqlDate.toLocalDateTime().getMonthValue();
				String mes = String.valueOf(mesInt);
				if (mesInt <= 9) {
					mes = "0" + mes;
				}
				
				int ano = sqlDate.toLocalDateTime().getYear();
				String dataAlimento = ano + "-" + mes + "-" + dia;
				alimento.setDataAlimento(dataAlimento);
				
				int horaInt = sqlDate.toLocalDateTime().getHour();
				String hora = String.valueOf(horaInt);
				if (horaInt <= 9) {
					hora = "0" + hora;
				}
				int minutoInt = sqlDate.toLocalDateTime().getMinute();
				String minuto = String.valueOf(minutoInt);
				if (minutoInt <= 9) {
					minuto = "0" + minuto;
				}
				
				String horaAlimento = hora + ":" + minuto;
				
				alimento.setHoraAlimento(horaAlimento);
				String categoria = rs.getString("CATEGORIA");
				alimento.setCategoria(categoria);
				short kcal = rs.getShort("KCAL");
				alimento.setKcal(kcal);
				String descricao = rs.getString("DESCRICAO");
				alimento.setDescricao(descricao);
			}
			rs.close();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alimento;
	}
	
	
	public int add(long id, Alimento alimento) {
		Connection conexao = ConnectionManager.getInstance().getConnection();
		try {
			PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_ALIMENTO (ID_ALIMENTO, DT_ALIMENTO, CATEGORIA, KCAL, DESCRICAO, USUARIO_ID_USUARIO) "
															+ "VALUES (NEXT VALUE FOR SEQ_ALIMENTO, ?, ?, ?, ?, ?)");
			String dataAlimento = alimento.getDataAlimento() + ":00";
			dataAlimento = dataAlimento.replace('T', ' ');
			stmt.setTimestamp(1, java.sql.Timestamp.valueOf(dataAlimento));
			stmt.setString(2, alimento.getCategoria());
			stmt.setShort(3, alimento.getKcal());
			stmt.setString(4, alimento.getDescricao());
			stmt.setLong(5, id);
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
	
	
	public int update(Alimento alimento) {
		Connection conexao = ConnectionManager.getInstance().getConnection();
		try {
			PreparedStatement stmt = conexao.prepareStatement("UPDATE T_ALIMENTO SET CATEGORIA = ?, KCAL = ?, DESCRICAO = ?, DT_ALIMENTO = ? WHERE ID_ALIMENTO = ?");
			stmt.setString(1, alimento.getCategoria());
			stmt.setShort(2, alimento.getKcal());
			stmt.setString(3, alimento.getDescricao());
			String dataAlimento = alimento.getDataAlimento() + ":00";
			dataAlimento = dataAlimento.replace('T', ' ');
			stmt.setTimestamp(4, java.sql.Timestamp.valueOf(dataAlimento));
			stmt.setLong(5, alimento.getIdAlimento());
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
			PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_ALIMENTO WHERE ID_ALIMENTO = ?");
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
