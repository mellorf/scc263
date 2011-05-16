package org.usp.dropbox.core;

import java.io.*;
import java.sql.*;
import org.usp.dropbox.db.*;
import org.usp.dropbox.config.*;

public class Directory implements Default {
	private int inode;
	private int iparent;
	private String name;

	public Directory() {
		this.inode = this.iparent = -1;
		this.name = null;
	}

	public Directory(int inode) throws Exception {
		Database db = DBManager.getInstance().getDatabase();
		Directory directory = Directory.next(db.query("select inode, iparent, name from tbDirectory where inode = "+inode));
		this.inode = directory.getINode();
		this.name = directory.getName();
		this.iparent = directory.getIParent();
		DBManager.getInstance().closeDatabase(db);
	}

	private Directory(int inode, int iparent,
			String name) 
		throws Exception {
		this.inode = inode;
		this.iparent = iparent;
		this.name = name;
	}

	public void setINode(int inode) { this.inode = inode; }
	public void setIParent(int iparent) { 
		this.iparent = iparent; 
	}
	public void setIParent(Directory parent) { 
		this.iparent = parent.getIParent(); 
	}
	public void setName(String name) { this.name = name; }

	public int getINode() { return this.inode; }
	public int getIParent() { return this.iparent; }
	public String getName() { return this.name; }

	public void insert() throws Exception {
		DBTransaction.getInstance().runTransaction(
				this, "true_insert", new Object[] {}
				);
	}

	public void true_insert() throws Exception {

		Database db = DBManager.getInstance().getDatabase();
		db.update("insert into tbDirectory (iparent, name) values ("+this.iparent+", '"+this.name+"')");

		ResultSet rs = db.query("select max(inode) as inode from tbDirectory");
		if (rs.next()) {
			this.inode = rs.getInt("inode");
		}

		// creating the physical directory
		File file = new File(getPath());
		file.mkdir();

		DBManager.getInstance().closeDatabase(db);
	}

	public Directory mkdir(String name) throws Exception {
		Directory child = new Directory();
		child.setIParent(this.inode);
		child.setName(name);
		child.insert();
		return child;
	}

	public DropFile touch(String name, String mimetype) 
			throws Exception {
		DropFile file = new DropFile();
		file.setName(name);
		file.setMimeType(mimetype);
		file.setIParent(this);
		file.setSize(0);
		file.insert();
		return file;
	}

	private void rmdir(Database db,
			Directory directory) throws Exception {
		if (!directory.hasChildrenDirs(db)) {
			System.out.println("Removendo: "+
					directory.getName());
			directory.remove();
		} else {
			ResultSet rs = directory.getDirectories(db);
			Directory dir = null;
			while ((dir = Directory.next(rs)) != null) {
				rmdir(db, dir);
				dir.remove();
			}
		}
	}

	public void rmdir() throws Exception {
		Database db = DBManager.getInstance().getDatabase();
		rmdir(db, this);
		remove();
		DBManager.getInstance().closeDatabase(db);
	}

	public String getPath() throws Exception {
		String path = this.name;
		Directory parent = null;
		int inode = -1;
		int iparent = this.iparent;

		Database db = DBManager.getInstance().getDatabase();
		while (iparent != -1) {
			parent = findByPrimaryKey(db, iparent);
			path = parent.getName() + "/" + path;
			iparent = parent.getIParent();
			inode = parent.getINode();
		}

		path = dropboxPath + "/" + path;
		DBManager.getInstance().closeDatabase(db);
		return path;
	}

	public void update() throws Exception {
		Database db = DBManager.getInstance().getDatabase();
		db.update("update tbDirectory set iparent = "+this.iparent+", name = '"+this.name+"' where inode = "+this.inode);
		DBManager.getInstance().closeDatabase(db);
	}

	public void remove() throws Exception {
		Database db = DBManager.getInstance().getDatabase();

		// Removing files inside this directory
		ResultSet rs = getDropFiles(db);
		DropFile file = null;
		while ((file = DropFile.next(rs)) != null) {
			file.remove();
		}

		// removing directory from database
		db.update("delete from tbDirectory where inode = "+this.inode);

		// removing physical directory
		File dir = new File(getPath());
		dir.delete(); // it must be empty

		DBManager.getInstance().closeDatabase(db);
	}

	public static ResultSet findAll(Database db) throws Exception {
		return db.query("select inode, iparent, name from tbDirectory");
	}

	public static Directory findByPrimaryKey(Database db, 
			int inode) throws Exception {
		return Directory.next(db.query("select inode, iparent, name from tbDirectory where inode = "+inode));
	}

	public static ResultSet findByParent(Database db, 
			int iparent) throws Exception {
		return db.query("select inode, iparent, name from tbDirectory where iparent = "+iparent+" order by name asc");
	}

	public static Directory next(ResultSet rs) throws Exception {
		Directory directory = null;

		if (rs.next()) {
			directory = new Directory(
				rs.getInt("inode"),
				rs.getInt("iparent"),
				rs.getString("name")
				);
		}

		return directory;
	}

	// relacionamento com directory quanto file
	public boolean hasChildrenDirs(Database db) 
		throws Exception {
		ResultSet rs = getDirectories(db);
		if (rs.next())
			return true;
		return false;
	}

	public ResultSet getDirectories(Database db) 
		throws Exception {
		return Directory.findByParent(db, this.inode);
	}

	public ResultSet getDropFiles(Database db) 
		throws Exception {
		return DropFile.findByParent(db, this.inode);
	}

	public static Directory getDirectory(Database db,
			int iparent, String name) throws Exception {
		return Directory.next(db.query("select inode, iparent, name from tbDirectory where iparent = "+iparent+" and name = '"+name+"'"));
	}

	public static Directory getDirectory(String path)
		throws Exception {
		// path = "teste@teste.com/dir0/sl0"
		String node[] = path.split("/");
		User user = new User(node[0]);
		Directory dir = user.getDirectory();

		Database db = DBManager.getInstance().getDatabase();

		int i = 1;
		while (i < node.length) {
			dir = dir.getDirectory(db, 
					dir.getINode(),
					node[i]);
			i++;
		}

		DBManager.getInstance().closeDatabase(db);

		return dir;
	}
}
