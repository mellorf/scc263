package org.usp.app08.sample;

import org.usp.app08.db.*;

public class Test extends Thread {

	public void run() {
		try {
			Singleton manager = 
				Singleton.getInstance();
			Database db = manager.getDatabase();
			// Usar db
			Thread.sleep(120);
			manager.closeDatabase(db);
		} catch (Exception e) {}
	}

	public static void main(String args[]) {
		for (int i = 0; i < 1000; i++)
			(new Test()).start();
	}
}
