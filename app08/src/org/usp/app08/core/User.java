package org.usp.app08.core;

import java.util.regex.*;
import java.sql.*;
import org.usp.app08.db.*;
import org.usp.app08.utils.*;

public class User {
	private String email;
	private String password;
	private String name;

	// 1. JavaBean eh uma classe que eu utilizo na app web
	// 2. Ela deve ter um construtor vazio implementado
	public User() {
		this.email = null;
		this.password = null;
		this.name = null;
	}

	private User(String email, String password, 
			String name) {
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public User(String email) throws Exception {
		Database db = new Database();
		db.connect();
		User user = findByEmail(db, email);
		db.close();

		if (user != null) {
			this.email = user.getEmail();
			this.password = user.getPassword();
			this.name = user.getName();
		} else {
			throw new Exception("User not found!");
		}
	}

	// setters
	public void setEmail(String email) throws Exception {
		// validar o email
		//Pattern pattern = new Pattern();
		//Matcher matcher = pattern.compile(".+@.+\\..*");

		//if (matcher.matches(email)) {
			this.email = email;
		//} else {
		//	throw new Exception("Invalid Email!");
		//}
	}

	public void setPassword(String password) throws Exception {
		if (password.length() > 7 &&
			password.length() < 17) {
				// encoding
				
				this.password = MD5.encode(password);

			} else {
				throw new Exception("Password out of bounds!");
			}
	}

	public void setName(String name) {
		this.name = name;
	}

	// getters
	public String getEmail() { return email; }
	private String getPassword() { return password; }
	public String getName() { return name; }

	// sqllers
	public void insert() throws Exception { 
		Database db = new Database();
		db.connect();
		db.update("insert into tbUser (email, password, name) values ('"+this.email+"', '"+this.password+"', '"+this.name+"')");
		db.close();
	}

	public void remove() throws Exception { 
		Database db = new Database();
		db.connect();
		db.update("delete from tbUser where email = '"+this.email+"'");
		db.close();
	}

	public void update() throws Exception { 
		Database db = new Database();
		db.connect();
		db.update("update set password = '"+this.password+"', name = '"+this.name+"' where email = '"+this.email+"'");
		db.close();
	}

	// finders
	public static ResultSet findAll(Database db) 
			throws Exception {
		return db.query("select email, password, name from tbUser");
	}

	public static User findByEmail(Database db, String email)
			throws Exception {
		return User.next(db.query("select email, password, name from tbUser where email = '"+email+"'"));
	}

	public static User findByEmailAndPassword(Database db,
			String email, String password) 
			throws Exception {

			password = MD5.encode(password);

		return User.next(db.query("select email, password, name from tbUser where email = '"+email+"' and password = '"+password+"'"));
	}

	public static User next(ResultSet rs) throws Exception {
		User user = null;

		if (rs.next()) {
			user = new User(
				rs.getString("email"),
				rs.getString("password"),
				rs.getString("name"));
		}

		return user;
	}

	public ResultSet getNews(Database db) throws Exception {
		return News.findByEmail(db, this.email);
	}
}
