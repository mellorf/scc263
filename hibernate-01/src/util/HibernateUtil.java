package util;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = 
		 new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) { }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
