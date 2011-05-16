package org.usp.app08.db;

import java.lang.reflect.*;
import org.usp.app08.core.*;

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

		//Method m[] = c.getMethods();
		//Constructor t[] = c.getConstructors();
		//Field f[] = c.getFields();
		//c.newInstance();
	}

	/*public synchronized void News_insert(News news) 
		throws Exception {
		news.true_insert();
	}

	public synchronized void User_insert(User user) {

	}*/
}
