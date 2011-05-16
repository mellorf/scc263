package org.usp.app08.config;

public interface DBConfig {
	public String driver = "org.postgresql.Driver";
	public String url = "jdbc:postgresql://localhost:5432/app08db";
	public String username = "app08";
	public String password = "password";
}
