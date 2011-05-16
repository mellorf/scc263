package org.usp.news;

import java.sql.*;
import java.net.*;
import java.io.*;

public class RSS implements Config {
	// atributos
	private String datetime;
	private String link;
	private String title;
	private String description;

	// conexão com banco de dados
	DBConnection db;

	public RSS() {}

	public RSS(String datetime, String link, String title, String description) {
		this.datetime = datetime;
		this.link = link.replace('\'', ' ');
		this.title = title.replace('\'', ' ');
		this.description = description.replace('\'', ' ');
	}

	public void setDatetime(String datetime) { this.datetime = datetime; }
	public void setLink(String link) { this.link = link.replace('\'', ' '); }
	public void setTitle(String title) { this.title = title.replace('\'', ' '); }
	public void setDescription(String description) { this.description = description.replace('\'', ' '); }

	public String getDatetime() { return datetime; }
	public String getLink() { return link; }
	public String getTitle() { return title; }
	public String getDescription() { return description; }

	public int insert() throws Exception {
		db = new DBConnection(driver, url, username, password);

		//System.out.println(this.link+" "+this.title+" "+this.description);
		int r = db.update("insert into _rss (datetime, link, title, description)"+ 
				"values (now(), '"+this.link+"', '"+
				this.title+"', '"+this.description+"')");
		db.close();
		return r;
	}

	public int remove() throws Exception {
		db = new DBConnection(driver, url, username, password);
		int r = db.update("delete from _rss where link = '"+this.link+"'");
		db.close();
		return r;
	}

	public int update() throws Exception {
		db = new DBConnection(driver, url, username, password);
		String sql = "update _rss set title = '"+this.title+"', "+
				" description = '"+this.description+"', "+
				" where link = '"+this.link+"'";
		int r = db.update(sql);
		db.close();
		return r;
	}

	public static ResultSet findByDateTime() throws Exception {
		DBConnection db = new DBConnection(driver, url, username, password);
		return db.query("select datetime, link, title, description from _rss order by datetime desc limit 2");
	}

	public static ResultSet findAll() throws Exception {
		DBConnection db = new DBConnection(driver, url, username, password);
		return db.query("select datetime, link, title, description from _rss");
	}

	public static RSS findByPrimaryKey(String link) throws Exception {
		DBConnection db = new DBConnection(driver, url, username, password);
		return next(db.query("select datetime, link, title, description from _rss where link = '"+link+"'"));
	}

	public static RSS next(ResultSet rs) throws Exception {
		if (rs.next()) {
			return new RSS( rs.getString("datetime"),
					rs.getString("link"),
					rs.getString("title"),
					rs.getString("description"));
		}
		return null;
	}
/*
	public static void main(String args[]) throws Exception {
		
		URL slashdot = new URL("http://rss.slashdot.org/Slashdot/slashdot");
		URLConnection sld = slashdot.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(sld.getInputStream()));
		BufferedWriter out = new BufferedWriter(new FileWriter("/tmp/slashdot.xml"));
		String inputLine;

		while ((inputLine = in.readLine()) != null)  {
			//System.out.println(inputLine);
			out.write(inputLine+"\n");
		}
		out.close();
		in.close();
		

		ParserSAX example = new ParserSAX();
		InputStream ins = new BufferedInputStream(new FileInputStream(new File("/tmp/slashdot.xml")));
		example.readXML(ins);

		// XML parser e gravar na base de dados
	}*/
}
