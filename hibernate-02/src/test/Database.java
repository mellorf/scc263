package test;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class Database {
    private static SessionFactory sessionFactory = null;

    static {
        try {
            sessionFactory = 
		 new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) { ex.printStackTrace(); }
    }

    public static SessionFactory getConfiguracao() {
        return sessionFactory;
    }
}
