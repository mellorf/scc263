package org.usp.app08.core;

// DAO - Data Access Object
//
//     Classe AllSqls
//
// SQLEmbedded Persistence
//
// 	Classes separadas com seus respectivos SQLs
//
// Framework (Hibernate, JPA)
//

import java.sql.*;
import java.net.*;
import org.usp.app08.db.*;

public class News {
	private int id;
	private String tmsp;
	private String headline;
	private String body;
	private String email;
	/*
	private static Object variavel = null;

	static {
		variavel = new Object();
	}*/

	// constructors -> JavaBean
	public News() {
		this.id = -1;
		this.tmsp = null;
		this.headline = null;
		this.body = null;
		this.email = null;
	}

	private News(int id, String tmsp, String headline,
			String body, String email) {
		this.id = id;
		this.tmsp = tmsp;
		this.headline = headline;
		this.body = body;
		this.email = email;
	}

	public News(int id) throws Exception {
		Database db = new Database();
		db.connect();
		News news = News.findById(db, id);
		db.close();
		this.id = news.id;
		this.tmsp = news.tmsp;
		this.headline = news.headline;
		this.body = news.body;
		this.email = news.email;
	}

	// setters
	//public void setId(int id) { this.id = id; }
	public void setTmsp(String tmsp) { this.tmsp = tmsp; }
	public void setHeadline(String headline) throws Exception {
		this.headline = URLEncoder.encode(headline, "UTF-8");
		//this.headline = headline;
	}
	public void setBody(String body) throws Exception { 
		this.body = URLEncoder.encode(body, "UTF-8");
		//this.body = body; 
	}
	public void setEmail(String email) {
		this.email = email;
	}

	// getters
	public int getId() { return this.id; }
	public String getTmsp() { return this.tmsp; }
	public String getHeadline() { return this.headline; }
	public String getBody() { return this.body; }
	public String getEmail() { return this.email; }

	// sqllers
	public void insert() throws Exception {
		DBTransaction dbt = DBTransaction.getInstance();
		dbt.runTransaction(this, "true_insert", 
				new Object[]{});
		//dbt.News_insert(this);
		//true_insert();
	}

	public void true_insert() throws Exception {
		//synchronized(variavel) {

			Database db = new Database();
			db.connect();
			// BEGIN WORK -> stored procedure
			db.update("insert into tbNews (tmsp, headline, body, email) values ('"+this.tmsp+"', '"+this.headline+"', '"+this.body+"', '"+this.email+"')");
			ResultSet rs = 
				db.query("select max(id) as id from tbNews");
			if (rs.next()) {
				this.id = rs.getInt("id");
			}
			// COMMIT

			db.close();

		//}
	}

	public void remove() throws Exception {
		Database db = new Database();
		db.connect();
		db.update("delete from tbNews where id = "+this.id);
		db.close();
	}


	public void update() throws Exception {
		Database db = new Database();
		db.connect();
		db.update("update tbNews set tmsp = '"+this.tmsp+"', headline = '"+this.headline+"', body = '"+this.body+"', email = '"+this.email+"' where id = "+this.id);
		db.close();
	}

	// finders
	public static ResultSet findAll(Database db)
		throws Exception {
		return db.query("select id, tmsp, headline, body, email from tbNews");
	}
	
	public static News findById(Database db, int id)
		throws Exception {
		return News.next(db.query("select id, tmsp, headline, body, email from tbNews where id = "+id));
	}

	public static ResultSet findByEmail(Database db,
			String email) throws Exception {
		return db.query("select id, tmsp, headline, body, email from tbNews where email = '"+email+"'");
	}

	public static ResultSet findLast(Database db,
			int n) throws Exception {
		return db.query("select id, tmsp, headline, body, email from tbNews order by tmsp desc limit "+n);
	}

	public static News next(ResultSet rs) throws Exception {
		News news = null;

		if (rs.next()) {
			news = new News(
				rs.getInt("id"),
				rs.getString("tmsp"),
				rs.getString("headline"),
				rs.getString("body"), 
				rs.getString("email")
					);
		}

		return news;
	}

	public User getUser() throws Exception {
		return new User(this.email);
	}

	public static void main(String args[]) throws Exception {
		News news = new News();
		news.setHeadline("Testando");
		news.setTmsp("2011-04-11 11:00:00");
		news.setBody("Body");
		news.setEmail("teste@teste.com");
		news.insert();
	}
}
