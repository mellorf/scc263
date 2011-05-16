package org.usp.dropbox.core;

import java.io.*;
import java.sql.*;
import org.usp.dropbox.db.*;

public class DropFile {
	private int inode;
	private String name;
	private String mimetype; // mime type
	private int iparent;
	private long size;

	public DropFile() {
		this.inode = this.iparent = -1;
		this.size = -1;
		this.mimetype = this.name = null;
	}

	public DropFile(int inode) throws Exception {
		Database db = DBManager.getInstance().getDatabase();
		DropFile file = DropFile.next(db.query("select inode, name, mimetype, iparent, size from tbDropFile where inode = "+inode));
		this.inode = file.getINode();
		this.name = file.getName();
		this.mimetype = file.getMimeType();
		this.iparent = file.getIParent();
		this.size = file.getSize();
		DBManager.getInstance().closeDatabase(db);
	}

	private DropFile(int inode, int iparent, String name, 
			String mimetype, long size) 
		throws Exception {
		this.inode = inode;
		this.iparent = iparent;
		this.name = name;
		this.mimetype = mimetype;
		this.size = size;
	}

	public void setINode(int inode) { this.inode = inode; }
	public void setIParent(Directory parent) { 
		this.iparent = parent.getINode();
	}
	public void setIParent(int iparent) { 
		this.iparent = iparent; 
	}
	public void setName(String name) { this.name = name; }
	public void setMimeType(String mimetype) { 
		this.mimetype = mimetype; 
	}
	public void setSize(long size) { this.size = size; }

	public int getINode() { return this.inode; }
	public int getIParent() { return this.iparent; }
	public String getName() { return this.name; }
	public String getMimeType() { return this.mimetype; }
	public long getSize() { return this.size; }

	public void insert() throws Exception {
		DBTransaction.getInstance().runTransaction(
				this, "true_insert", new Object[] {}
				);
	}

	public void true_insert() throws Exception {
		Database db = DBManager.getInstance().getDatabase();
		db.update("insert into tbDropFile (iparent, name, mimetype, size) values ("+this.iparent+", '"+this.name+"', '"+this.mimetype+"', "+this.size+")");

		ResultSet rs = db.query("select max(inode) as inode from tbDropFile");
		if (rs.next()) {
			this.inode = rs.getInt("inode");
		}

		// touching physical file
		File file = new File(getParent().getPath()+"/"+
				this.name);
		file.createNewFile();

		DBManager.getInstance().closeDatabase(db);
	}

	public void update() throws Exception {
		Database db = DBManager.getInstance().getDatabase();
		db.update("update tbDropFile set iparent = "+this.iparent+", name = '"+this.name+"', mimetype = '"+this.mimetype+"', size = "+this.size+" where inode = "+this.inode);
		DBManager.getInstance().closeDatabase(db);
	}

	public void remove() throws Exception {
		Database db = DBManager.getInstance().getDatabase();
		db.update("delete from tbDropFile where inode = "+this.inode);
		// Removing file
		File file = new File(
			getParent().getPath()+"/"+
			this.name);
		file.delete();

		DBManager.getInstance().closeDatabase(db);
	}

	public static ResultSet findAll(Database db) throws Exception {
		return db.query("select inode, iparent, name, mimetype, size from tbDropFile");
	}

	public static DropFile findByPrimaryKey(Database db, 
			int inode) throws Exception {
		return DropFile.next(db.query("select inode, iparent, name, mimetype, size from tbDropFile where inode = "+inode));
	}

	public static ResultSet findByParent(Database db, 
			int iparent) throws Exception {
		return db.query("select inode, iparent, name, mimetype, size from tbDropFile where iparent = "+iparent+" order by name asc");
	}

	public static DropFile next(ResultSet rs) throws Exception {
		DropFile file = null;

		if (rs.next()) {
			file = new DropFile(
				rs.getInt("inode"),
				rs.getInt("iparent"),
				rs.getString("name"),
				rs.getString("mimetype"),
				rs.getLong("size")
				);
		}

		return file;
	}

	public Directory getParent() throws Exception {
		Database db = DBManager.getInstance().getDatabase();
		Directory parent =
		   Directory.findByPrimaryKey(db, this.iparent);
		DBManager.getInstance().closeDatabase(db);
		return parent;
	}
}
