package org.usp.app07.config;

public interface DBConfig {
	// constantes
	// final -> constante
	public String driver = "org.postgresql.Driver";
	public String url = "jdbc:postgresql://localhost:5432/app07db";
	public String username = "app07";
	public String password = "password";
}
