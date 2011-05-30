package events;

import org.hibernate.Session;
import java.util.Date;
import util.HibernateUtil;
import java.io.*;

public class EventManager {
    private void createAndStoreEvent(String title, Date theDate, 
		    String filename) 
	    throws Exception {
        Session session = 
		HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

	// lendo o arquivo de imagem
	File f = new File(filename);
	long length = f.length();

	System.out.println("Imagem com "+length+" bytes");

	byte[] file = new byte[(int) length];

	BufferedInputStream bis = 
		new BufferedInputStream(new FileInputStream(filename));
	bis.read(file, 0, (int) length);
	bis.close();

        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
	theEvent.setPicture(file);
        System.out.println("Chave primária = "+session.save(theEvent));

        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }

    public void load(Long id) throws Exception {
	Session session = 
		HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();

	Event e = (Event) session.load(Event.class, id);

	System.out.println(e.getId()+", "+e.getTitle()+", "+
			e.getPicture());

	BufferedOutputStream bufferedOutput = null;
	bufferedOutput = new BufferedOutputStream(new FileOutputStream("/tmp/mount-output.jpg"));
	bufferedOutput.write(e.getPicture());
	bufferedOutput.close();

	session.getTransaction().commit();
    }

    public static void main(String[] args) throws Exception {
        EventManager mgr = new EventManager();
        if (args[0].equals("store")) {
            mgr.createAndStoreEvent("My Event", new Date(), 
			    "/tmp/mount.jpg");
	    mgr.load(new Long(1));
	}
    }
}
