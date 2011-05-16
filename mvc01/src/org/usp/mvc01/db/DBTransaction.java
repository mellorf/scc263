package org.usp.mvc01.db;

import java.lang.reflect.*;
import org.usp.mvc01.core.*;

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
