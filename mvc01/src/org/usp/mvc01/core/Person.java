package org.usp.mvc01.core;

import java.sql.*;
import org.usp.mvc01.db.*;
import org.usp.mvc01.config.*;

public class Person {
	private String email; // PK
	private String name;
	private String address;
	private String phone;

	public Person() {
		this.email = null;
		this.name = null;
		this.address = null;
		this.phone = null;
	}

	public Person(String email) throws Exception {
		Database db = DBManager.getInstance().getDatabase();
		Person p = findByPrimaryKey(db, email);
		this.email = p.getEmail();
		this.name = p.getName();
		this.address = p.getAddress();
		this.phone = p.getPhone();
		DBManager.getInstance().closeDatabase(db);
	}

	private Person(String email, String name, String address, String phone) {
		this.email = email;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	// setters
	public void setEmail(String email) { this.email = email; }
	public void setName(String name) { this.name = name; }
	public void setAddress(String address) { this.address = address ; }
	public void setPhone(String phone) { this.phone = phone; }

	// getters
	public String getEmail() { return this.email; }
	public String getName() { return this.name; }
	public String getAddress() { return this.address; }
	public String getPhone() { return this.phone; }

	// sqllers
	public void insert() throws Exception {
		Database db = DBManager.getInstance().getDatabase();
		db.update("insert into tbPerson (email, name, address, phone) values ('"+this.email+"', '"+this.name+"','"+this.address+"','"+this.phone+"')");
		DBManager.getInstance().closeDatabase(db);
	}

	public void remove() throws Exception {
		Database db = DBManager.getInstance().getDatabase();
		db.update("delete from tbPerson where email = '"+this.email+"'");
		DBManager.getInstance().closeDatabase(db);
	}

	public void update() throws Exception {
		Database db = DBManager.getInstance().getDatabase();
		db.update("update tbPerson set name = '"+this.name+"', address = '"+this.address+"', phone = '"+this.phone+"' where email = '"+this.email+"'");
		DBManager.getInstance().closeDatabase(db);
	}

	public static ResultSet findAll(Database db) throws Exception { 
		return db.query("select email, name, address, phone from tbPerson");
	}

	public static Person findByPrimaryKey(Database db, String email) 
		throws Exception { 
		return Person.next(db.query("select email, name, address, phone from tbPerson where email = '"+email+"'"));
	}

	public static ResultSet findByName(Database db, String name) 
		throws Exception { 
		return db.query("select email, name, address, phone from tbPerson where name like '%"+name+"%'");
	}

	public static Person next(ResultSet rs) throws Exception {
		Person p = null;

		if (rs.next()) {
			p = new Person(
					rs.getString("email"),	
					rs.getString("name"),	
					rs.getString("address"),	
					rs.getString("phone")
				);
		}

		return p;
	}

	// Unit Test
	public static void main(String args[]) throws Exception {
		Person p = new Person();
		p.setEmail("teste@teste.com");
		p.setName("teste");
		p.setAddress("address");
		p.setPhone("phone");
		p.insert();
	}
}
