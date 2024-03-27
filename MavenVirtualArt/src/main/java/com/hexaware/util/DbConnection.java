package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hexa3";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private Connection connection;

    public Connection openConnection() throws SQLException {
    	 this.connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    	    return this.connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeStatement() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
