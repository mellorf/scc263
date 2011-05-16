package org.usp.dropbox.core;

import java.io.*;
import java.sql.*;
import org.usp.dropbox.db.*;
import org.usp.dropbox.config.*;

public class User implements Default {
	private String email;
	private String name;
	private String password;
	private long freespace;
	private long space;
	private int inode; // root

	public User() {
		this.email = this.name = this.password = null;
		this.inode = -1;
		this.freespace = this.space = defaultSpace;
	}

	public User(String email) throws Exception {
		Database db = DBManager.getInstance().getDatabase();
		User user = User.next(db.query("select email, name, password, freespace, space, inode from tbUser where email = '"+email+"'"));
		this.email = user.getEmail();
		this.name = user.getName();
		this.password = user.getPassword();
		this.freespace = user.getFreeSpace();
		this.space = user.getSpace();
		this.inode = user.getINode();
		DBManager.getInstance().closeDatabase(db);
	}

	private User(String email, String name, String password, 
			long freespace, long space, int inode) throws Exception {
		this.email = email;
		this.name = name;
		this.password = password;
		this.freespace = freespace;
		this.space = space;
		this.inode = inode;
	}

	public void setEmail(String email) { this.email = email; }
	public void setName(String name) { this.name = name; }
	public void setPassword(String password) { 
		this.password = password; 
	}
	public void setFreeSpace(long freespace) { 
		this.freespace = freespace; 
	}
	public void setSpace(long space) { this.space = space; }
	private void setINode(int inode) { this.inode = inode; }

	public String getEmail() { return this.email; }
	public String getName() { return this.name; }
	public String getPassword() { return this.password; }
	public long getFreeSpace() { return this.freespace; }
	public long getSpace() { return this.space; }
	public int getINode() { return this.inode; }

	public void insert() throws Exception {

		// criar diretorio root
		Directory directory = new Directory();
		directory.setName(this.email);
		directory.setIParent(-1);
		directory.insert();
		this.inode = directory.getINode();

		Database db = DBManager.getInstance().getDatabase();
		db.update("insert into tbUser (email, name, password, freespace, space, inode) values ('"+this.email+"', '"+this.name+"', '"+this.password+"', "+this.freespace+", "+this.space+", "+this.inode+")");
		
		DBManager.getInstance().closeDatabase(db);
	}

	public void update() throws Exception {
		Database db = DBManager.getInstance().getDatabase();
		db.update("update tbUser set name ='"+this.name+"', password = '"+this.password+"', freespace = "+this.freespace+", space = "+this.space+", inode = "+this.inode+" where email = '"+this.email+"'");
		DBManager.getInstance().closeDatabase(db);
	}

	public void remove() throws Exception {
		// Removing user
		Database db = DBManager.getInstance().getDatabase();
		db.update("delete from tbUser where email = '"+this.email+"'");

		// Removing directories and files
		getDirectory().rmdir();

		DBManager.getInstance().closeDatabase(db);
	}

	public static ResultSet findAll(Database db) throws Exception {
		return db.query("select email, name, password, freespace, space, inode from tbUser");
	}

	public static User findByPrimaryKey(Database db, 
			String email) throws Exception {
		return User.next(db.query("select email, name, password, freespace, space, inode from tbUser where email = '"+email+"'"));
	}

	public static User findByEmailPassword(Database db, 
			String email, String password) 
		throws Exception {
		return User.next(db.query("select email, name, password, freespace, space, inode from tbUser where email = '"+email+"' and password = '"+password+"'"));
	}

	public static User findByINode(Database db,
			int inode) throws Exception {
		return User.next(db.query("select email, name, password, freespace, space, inode from tbUser where inode = "+inode));
	}

	public static User next(ResultSet rs) throws Exception {
		User user = null;

		if (rs.next()) {
			user = new User(
				rs.getString("email"),
				rs.getString("name"),
				rs.getString("password"),
				rs.getLong("freespace"),
				rs.getLong("space"),
				rs.getInt("inode")
				);
		}

		return user;
	}

	// relacionamento com directory
	public Directory getDirectory() throws Exception {
		return new Directory(this.inode);
	}

	public boolean verifyDirectoryAccess(int inode)
		throws Exception {

		Database db = DBManager.getInstance().getDatabase();
		Directory d = Directory.findByPrimaryKey(
				db, inode);
		while (d.getIParent() != -1) {
			d = Directory.findByPrimaryKey(
					db, d.getIParent());
		}

		DBManager.getInstance().closeDatabase(db);

		return d.getName().equals(this.email);
	}

	public static void unitTest01() throws Exception {
		System.out.println("Creating user...");
		User user = new User();
		user.setName("Teste");
		user.setEmail("teste@teste.com");
		user.setPassword("senha");
		user.setFreeSpace(100);
		user.setSpace(100);
		user.insert();
	}

	public static void unitTest02() throws Exception {
		System.out.println("Creating additional directories...");
		User user = new User("teste@teste.com");
		Directory root = user.getDirectory();
		Directory dir0 = root.mkdir("dir0");
		Directory dir1 = root.mkdir("dir1");
		Directory dir2 = root.mkdir("dir2");

		Directory sl0 = dir0.mkdir("secondlevel0");
		dir0.mkdir("secondlevel1");
		dir0.mkdir("secondlevel2");

		DropFile file0 = sl0.touch("file.txt", 
				"text/html");
	}

	public static void unitTest03() throws Exception {
		System.out.println("Removing additional directories...");
		User user = new User("teste@teste.com");
		Directory root = user.getDirectory();
		root.rmdir();
	}

	public static void unitTest04() throws Exception {
		System.out.println("Removing user and the root direcory...");
		User user = new User("teste@teste.com");
		user.remove();
	}


	public static void main(String args[]) throws Exception {
		unitTest01();
		unitTest02();
		unitTest03();
		unitTest04();
	}
}
