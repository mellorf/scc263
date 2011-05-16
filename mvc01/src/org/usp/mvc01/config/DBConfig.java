package org.usp.mvc01.config;

public interface DBConfig {
	public String driver = "org.postgresql.Driver";
	public String url = "jdbc:postgresql://localhost:5432/mvc01db";
	public String username = "mvc01";
	public String password = "password";
}
