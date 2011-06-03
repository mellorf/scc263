package events;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Date;
import util.HibernateUtil;

public class EventManager {
    private void createAndStoreEvent(String title, Date theDate) {
        Session session = 
		HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        Event theEvent = new Event();
        theEvent.setId(new Integer(1));
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        System.out.println("Chave primária = "+session.save(theEvent));

        session.getTransaction().commit();

        HibernateUtil.getSessionFactory().close();
    }

    public static void main(String[] args) {
        EventManager mgr = new EventManager();
        if (args[0].equals("store"))
            mgr.createAndStoreEvent("My Event", new Date());
    }
}
