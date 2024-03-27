package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing database connections.
 */

public class DbConnection implements AutoCloseable{
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hexa3";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private Connection connection;
    public static Connection conn;
    /**
     * Retrieves a connection to the database.
     * @return A Connection object representing the database connection.
     */

	public static Connection getConnection() {	
		String url = "jdbc:mysql://localhost:3306/hexa3";
		String username = "root";
		String pwd = "123456"; 
		
		try {
			conn = DriverManager.getConnection(url, username, pwd);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
     * Method to create connection to database
     * @return A Connection object representing the database connection.
     */
    public Connection openConnection() throws SQLException {
    	 this.connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    	    return this.connection;
    }
    /**
     * Method to close connection to database
     * @return A Connection object representing the closing of database connection.
     */
    public void closeConnection() throws SQLException{
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method to create connection to database
     * @return A Connection object representing the closing of database connection.
     */
    public void closeStatement() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
