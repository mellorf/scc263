package org.usp.dropbox.config;

public interface DBConfig {
	public String driver = "org.postgresql.Driver";
	public String url = "jdbc:postgresql://localhost:5432/dropboxdb";
	public String username = "dropbox";
	public String password = "password";
}
