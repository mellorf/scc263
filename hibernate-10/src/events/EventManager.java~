package events;

import org.hibernate.Session;
import java.util.Date;
import util.HibernateUtil;

public class EventManager {
    private void createAndStoreEvent(String title, Date theDate, String description) {
        Session session = 
		HibernateUtil.getSessionFactory().getCurrentSession();

	EventPK chave = new EventPK(title, theDate);
        Event theEvent = new Event();
        theEvent.setEventPK(chave);
        theEvent.setDescription(description);

        session.beginTransaction();
        System.out.println("Chave primária = "+session.save(theEvent));
        session.getTransaction().commit();

        HibernateUtil.getSessionFactory().close();
    }

    public static void main(String[] args) {
        EventManager mgr = new EventManager();
        if (args[0].equals("store"))
            mgr.createAndStoreEvent(
			"My Event", new Date(), "My Description"
		);
    }
}
