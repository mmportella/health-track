package br.com.fiap.healthtrack.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.healthtrack.model.beans.Usuario;

public class UsuarioDAO {

	public Usuario login(String email, String senha) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(0);
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_USUARIO WHERE EMAIL = ? AND SENHA = ?");
			stmt.setString(1, email);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				usuario.setIdUsuario(rs.getLong("ID_USUARIO"));
				usuario.setNomeUsuario(rs.getString("NOME_USUARIO"));
				java.sql.Date sqlData = rs.getDate("DT_NASCIMENTO");
				String data = sqlData.toString();
				usuario.setDataNascimento(data);
				usuario.setGenero(rs.getString("GENERO"));
				usuario.setAltura(rs.getShort("ALTURA"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setSenha(rs.getString("SENHA"));
			}
			rs.close();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	
	public Usuario get(long id) {
		Usuario usuario = new Usuario();
		try {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_USUARIO WHERE ID_USUARIO = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				usuario.setIdUsuario(rs.getLong("ID_USUARIO"));
				usuario.setNomeUsuario(rs.getString("NOME_USUARIO"));
				java.sql.Date sqlData = rs.getDate("DT_NASCIMENTO");
				String data = sqlData.toString();
				usuario.setDataNascimento(data);
				usuario.setGenero(rs.getString("GENERO"));
				usuario.setAltura(rs.getShort("ALTURA"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setSenha(rs.getString("SENHA"));
			}
			rs.close();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	
	public int add(Usuario usuario) {
		String email = usuario.getEmail();
		String senha = usuario.getSenha();
		long id = login(email, senha).getIdUsuario();
		if (id == 0) {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			try {
				PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_USUARIO VALUES (NEXT VALUE FOR SEQ_USUARIO, ?, ?, ?, ?, ?, ?)");
				stmt.setString(1, usuario.getNomeUsuario());
				stmt.setDate(2, java.sql.Date.valueOf(usuario.getDataNascimento()));
				String genero = " ";
				if (usuario.getGenero() == "Masculino") {
					genero = "M";
				} else {
					genero = "F";
				}
				stmt.setString(3, genero);
				stmt.setShort(4, usuario.getAltura());
				stmt.setString(5, email);
				stmt.setString(6, senha);
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
		}
		return 0;
	}
	
	
	public int update(Usuario usuario) {
			Connection conexao = ConnectionManager.getInstance().getConnection();
			try {
				PreparedStatement stmt = conexao.prepareStatement("UPDATE T_USUARIO SET NOME_USUARIO = ?, DT_NASCIMENTO = ?, GENERO = ?, ALTURA = ?, EMAIL = ?, SENHA = ? WHERE ID_USUARIO = ?");
				stmt.setString(1, usuario.getNomeUsuario());
				stmt.setDate(2, java.sql.Date.valueOf(usuario.getDataNascimento()));
				String genero = " ";
				if (usuario.getGenero().equals("Masculino")) {
					genero = "M";
				} else {
					genero = "F";
				}
				stmt.setString(3, genero);
				stmt.setShort(4, usuario.getAltura());
				stmt.setString(5, usuario.getEmail());
				stmt.setString(6, usuario.getSenha());
				stmt.setLong(7, usuario.getIdUsuario());
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
	
	
	public int delete(long id) {
		Connection conexao = ConnectionManager.getInstance().getConnection();
		try {
			PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_USUARIO WHERE ID_USUARIO = ?");
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
