package br.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import br.com.util.PropertiesDB;

public class DB {
	private static Connection connection = null;
	
	public static Connection getConnection() {
		if (connection == null) {
			try {
				Properties properties = new PropertiesDB().getPropertiesDB();
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);
			}
			catch (SQLException | ClassNotFoundException error) {
				throw new RuntimeException(error.getMessage());
			}
		}
		return connection;
	}
	
	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			}
			catch (SQLException error) {
				throw new RuntimeException(error.getMessage());
			}
		}
	}
	
	public static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException error) {
				throw new RuntimeException(error.getMessage());
			}
		}	
	}
	
	public static void closeResultset(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException error) {
				throw new RuntimeException(error);
			}
		}
	}
	
	public static void replaceConnection() {
		connection = null;
	}
}
