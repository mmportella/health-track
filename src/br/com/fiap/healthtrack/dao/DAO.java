package br.com.fiap.healthtrack.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
	private Connection connection;
	
	public DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	private void openConnection() {
		try {
			this.connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "user", "pass");
			this.connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Connection getConnection() {
		openConnection();
		return this.connection;
	}
	
	
	private void closeConnection() {
		try {
			if (this.connection != null) {
				this.connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public int executeCommand(PreparedStatement stmt) throws SQLException {
		int j = 0;
		try {
			j = stmt.executeUpdate();
			this.connection.commit();
		} catch (SQLException e) {
			this.connection.rollback();
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return j;
	}
	
	
	public ResultSet getData(PreparedStatement stmt) {
		ResultSet resultSet = null;
		try {
			resultSet = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return resultSet;
	}
	
	
}