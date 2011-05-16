package org.usp.news;

import java.sql.*;

public class News implements Config {
	// atributos
	private int code;
	private String datetime;
	private String title;
	private String body;

	// conexão com banco de dados
	DBConnection db;

	public News() {}
	public News(int code, String datetime, String title, String body) {
		this.code = code;
		this.datetime = datetime;
		this.title = title;
		this.body = body;
	}

	public void setCode(int code) { this.code = code; }
	public void setDatetime(String datetime) { this.datetime = datetime; }
	public void setTitle(String title) { this.title = title; }
	public void setBody(String body) { this.body = body; }

	public int getCode() { return code; }
	public String getDatetime() { return datetime; }
	public String getTitle() { return title; }
	public String getBody() { return body; }

	public int insert() throws Exception {
		db = new DBConnection(driver, url, username, password);
		int r = db.update("insert into _news (datetime, title, body)"+ 
				"values ('"+this.datetime+"', '"+
				this.title+"', '"+this.body+"')");

		ResultSet rs = db.query("select last_value from _news_seq");

		if (rs.next()) {
			this.code = rs.getInt("last_value");
		}

		db.close();
		return r;
	}

	public int remove() throws Exception {
		db = new DBConnection(driver, url, username, password);
		int r = db.update("delete from _news where code = "+this.code);
		db.close();
		return r;
	}

	public int update() throws Exception {
		db = new DBConnection(driver, url, username, password);
		String sql = "update _news set datetime = '"+this.datetime+"', "+
				" title = '"+this.title+"', body = '"+this.body+"' "+
				" where code = "+this.code;
		int r = db.update(sql);
		db.close();
		return r;
	}

	public static ResultSet findByDateTime() throws Exception {
		DBConnection db = new DBConnection(driver, url, username, password);
		return db.query("select code, datetime, title, body from _news where datetime < now() order by datetime desc limit 20");
	}

	public static ResultSet findAll() throws Exception {
		DBConnection db = new DBConnection(driver, url, username, password);
		return db.query("select code, datetime, title, body from _news");
	}

	public static News findByPrimaryKey(int code) throws Exception {
		DBConnection db = new DBConnection(driver, url, username, password);
		return next(db.query("select code, datetime, title, body from _news where code = "+code));
	}

	public static News next(ResultSet rs) throws Exception {
		if (rs.next()) {
			return new News(rs.getInt("code"), 
					rs.getString("datetime"),
					rs.getString("title"),
					rs.getString("body"));
		}
		return null;
	}
}
