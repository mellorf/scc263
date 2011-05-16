package org.usp.app07.core;

import java.util.regex.*;
import org.usp.app07.db.*;
import org.usp.app07.robot.*;
import java.sql.*;
import java.net.*;

public class Page {
	private String tmsp;
	private String url;
	private String body;

	public Page() {
		this.tmsp = null;
		this.url = null;
		this.body = null;
	}

	public Page(String tmsp, String url, String body) 
		throws Exception {
		setTmsp(tmsp);
		setUrl(url);
		setBody(body);
	}

	// setters
	public void setTmsp(String tmsp) { this.tmsp = tmsp; }
	public void setUrl(String url) { this.url = url; }
	public void setBody(String body) throws Exception { 
		this.body = URLEncoder.encode(body, "UTF-8"); 
	}

	// getters
	public String getTmsp() { return this.tmsp; }
	public String getUrl() { return this.url; }
	public String getBody() { return this.body; }

	public static void newUrl(String url) throws Exception {
		String body = Robot.get(url);
		
		Page p = new Page();
		p.setTmsp("2011-03-11 11:00:00");
		p.setUrl(url);
		p.setBody(body);
		p.insert();
	}

	// Chamando Robot
	public static void robot() throws Exception {
		Database db = new Database();
		db.connect();
		ResultSet rs = Page.findAll(db);

		Page p = null;
		while ((p = Page.next(rs)) != null) {
			String body = Robot.get(p.getUrl());

			// procurar por urls dentro do body
			// buscar por essas paginas

			//String expr = "href=\"([^\"]*)";
        		String ereg = "href=\"https{0,1}:\\/\\/([^\"]*)\"";
	        	Pattern pt = Pattern.compile(ereg);
		        Matcher m = pt.matcher(body);

			while (m.find()) {
				System.out.println(m.group());
				String[] _url = 
					m.group().split("\"");
				Page.newUrl(_url[1]);
			}

			p.setBody(body);
			p.update();
		}

		db.close();
	}

	// sqllers
	public void insert() throws Exception {
		Database db = new Database();
		db.connect();

		db.update("insert into page (tmsp, url, body) values ('"+tmsp+"', '"+url+"', '"+body+"')");

		db.close();
	}

	public void remove() throws Exception {
		Database db = new Database();
		db.connect();

		db.update("delete from page where url = '"+url+"'");

		db.close();
	}

	public void update() throws Exception {
		Database db = new Database();
		db.connect();

		db.update("update page set tmsp = '"+tmsp+"', body = '"+body+"' where url = '"+url+"'");
		   //URLEncoder.encode(url, "UTF-8")+"'");
		   //URLEncoder.encode(url, "ISO-8859-1")+"'");

		db.close();
	}

	// finders
	public static ResultSet findAll(Database db) 
		throws Exception {
		return db.query("select tmsp, url, body from page");
	}

	public static ResultSet findByUrl(Database db, 
			String url) 
		throws Exception {
		return db.query("select tmsp, url, body from page where url = '"+url+"'");
	}

	public static ResultSet findByQuery(Database db, 
			String query) 
		throws Exception {
		return db.query("select tmsp, url, body from page where url like '%"+query+"%' or body like '%"+query+"%'");
	}

	public static Page next(ResultSet rs) throws Exception {
		Page p = null;

		if (rs.next()) {
			p = new Page();
			p.setTmsp(rs.getString("tmsp"));
			p.setUrl(rs.getString("url"));
			p.setBody(rs.getString("body"));
		}

		return p;
	}

	public static void test01() throws Exception {
		Page p = new Page();
		p.setTmsp("2011-03-04 10:30:00");
		p.setUrl("http://www.google.com");
		p.setBody("my body");
		p.insert();

		Page e = new Page("2011-03-04 10:31:00",
				"http://www.usp.br",
				"o corpo");
		e.insert();
		e.setBody("usp usp usp");
		e.update();

		Database db = new Database();
		db.connect();
		ResultSet rs = Page.findAll(db);

		/*
		while (rs.next()) {
			System.out.println(rs.getString("tmsp")
				+", "+ rs.getString("url")
				+", "+ rs.getString("body"));
		}*/

		Page p0 = null;
		while ((p0 = Page.next(rs)) != null) {
			System.out.println(p0.getTmsp());
			System.out.println(p0.getUrl());
			System.out.println(p0.getBody());
		}

		db.close();

		p.remove();
		e.remove();
	}

	public static void test02() throws Exception {
		Page.robot();
	}

	// Teste de unidade
	public static void main(String args[]) throws Exception {
		test02();
	}
}
