package org.usp.news;

import java.sql.*;

public class User implements Config {
	// atributos
	private String name;
	private String login;
	private String passwd;

	// conexão com banco de dados
	DBConnection db;

	public User() {}
	public User(String name, String login, String passwd) {
		this.name = name;
		this.login = login;
		this.passwd = passwd;
	}

	public void setName(String name) { this.name = name; }
	public void setLogin(String login) { this.login = login; }
	public void setPasswd(String passwd) { this.passwd = passwd; }

	public String getName() { return name; }
	public String getLogin() { return login; }
	public String getPasswd() { return passwd; }

	public int insert() throws Exception {
		db = new DBConnection(driver, url, username, password);
		int r = db.update("insert into _user (name, login, passwd) values ('"+
				this.name+"', '"+this.login+"', '"+
				this.passwd+"')");
		db.close();
		return r;
	}

	public int remove() throws Exception {
		db = new DBConnection(driver, url, username, password);
		int r = db.update("delete from _user where login = '"+this.login+"'");
		db.close();
		return r;
	}

	public int update() throws Exception {
		db = new DBConnection(driver, url, username, password);
		String sql = "update _user set name = '"+this.name+"', "+
				" passwd = '"+this.passwd+"' "+
				" where login = '"+this.login+"'";
		int r = db.update(sql);
		db.close();
		return r;
	}

	public static ResultSet findAll() throws Exception {
		DBConnection db = new DBConnection(driver, url, username, password);
		return db.query("select name, login, passwd from _user");
	}

	public static User findByPrimaryKey(String login) throws Exception {
		DBConnection db = new DBConnection(driver, url, username, password);
		return next(db.query("select name, login, passwd from _user where login = '"+login+"'"));
	}

	public static User next(ResultSet rs) throws Exception {
		if (rs.next()) {
			return new User(rs.getString("name"), 
					rs.getString("login"),
					rs.getString("passwd"));
		}
		return null;
	}
}
