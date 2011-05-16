package org.usp.news;

import java.sql.*;

public class DBConnection {

	Connection connection = null;

        String driver = null;
	String url = null;
	String username = null;
	String password = null;

	public DBConnection(String driver, String url,
			String username, String password) 
		throws Exception {

		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
	}

	public ResultSet query(String query) throws Exception {
		Statement statement = connection.createStatement();
		return statement.executeQuery(query);
	}

	public int update(String sql) throws Exception {
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(sql);
		statement.close();
		return result;
	}

	public void close() throws Exception {
		connection.close();
	}
}
