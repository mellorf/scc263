package org.usp.dropbox.db;

import java.lang.reflect.*;
import org.usp.dropbox.core.*;

public class DBTransaction {
	private static DBTransaction dbt = null;

	public synchronized static DBTransaction getInstance() {
		if (dbt == null)
			dbt = new DBTransaction();
		return dbt;
	}

	// Hibernate, JPA, ...
	public synchronized void runTransaction(Object obj, 
			String method, Object args[]) throws Exception {
		// Reflection API
		Class c = obj.getClass();
		Method m = c.getMethod(method);
		m.invoke(obj, args);
	}
}
