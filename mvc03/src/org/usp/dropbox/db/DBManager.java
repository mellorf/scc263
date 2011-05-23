package org.usp.dropbox.db;

import java.util.*;
import org.usp.dropbox.db.*;
import org.usp.dropbox.config.*;

class DatabaseException extends Exception {
	public DatabaseException(String msg) {
		super(msg);
	}
}

public class DBManager implements Default { // Singleton
	
	private static DBManager singleton = null;
	private Database[] connections; // pool
	private int size;

	private DBManager() throws Exception {
		this.connections = new Database[dbconnections];
		this.size = this.connections.length;

		for (int i = 0; i < dbconnections; i++) {
			Database db = new Database();
			db.connect();
			this.connections[i] = db;
		}
	}

	// metodo especial
	// JVM carregar esta classe, ela chama este metodo
	static {
		System.out.println("Chamando static...");
		try {
			singleton = new DBManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// tratamento de uma regiao critica
	public synchronized static DBManager getInstance() 
		throws Exception {
		return singleton;
	}

	// destrutor
	public void finalize() {
		try {
			// destrutor em Java
			for (int i = 0; i < this.size; i++) {
				Database db = this.connections[i];
				db.close();
			}
		} catch (Exception e) {}
	}

	public synchronized Database getDatabase() 
		throws DatabaseException {

		Database db = null;

		if (this.size > 0) {
			// 0 1
			// size = 2
			db = this.connections[--this.size];
		} else throw new DatabaseException("No conns");

		return db;
	}

	public synchronized void closeDatabase(Database db) 
		throws DatabaseException {
		// 0 1 4 3 2
		// size = 5
	
		if (db == null)
			throw new DatabaseException(
				   "Null pointer");

		for (int i = 0; i < this.size; i++) {
			if (this.connections[i].equals(db))
				throw new 
				   DatabaseException(
				   "Already closed");
		}

		this.connections[this.size++] = db;
	}
}
