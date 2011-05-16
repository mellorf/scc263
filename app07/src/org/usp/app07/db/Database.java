package org.usp.app07.db;

import java.sql.*; // JDBC API
import org.usp.app07.config.*; // interface DBConfig

public class Database implements DBConfig {
	private Connection conn;
	
	public Database() {
		this.conn = null;
	}

	public void connect() throws Exception {
		Class.forName(driver);
		this.conn = DriverManager.getConnection(url,
				username,
				password);
	}

	// insert, create, update, delete...
	public int update(String sql) throws Exception {
		Statement stmt = conn.createStatement();
		int ret = stmt.executeUpdate(sql);
		stmt.close();
		return ret;
	}

	// select 
	public ResultSet query(String sql) throws Exception {
		Statement stmt = conn.createStatement();
		return stmt.executeQuery(sql);
	}

	public void close() throws Exception {
		this.conn.close();
	}
}
