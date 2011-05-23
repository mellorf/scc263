package util;
import org.hibernate.*;
import org.hibernate.cfg.*;
public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    static {
        try {
            sessionFactory = 
		 new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
