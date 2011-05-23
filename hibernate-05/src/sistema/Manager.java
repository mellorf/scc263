package sistema;

import org.hibernate.Session;
import java.util.Date;
import util.HibernateUtil;

public class Manager {
    public static void main(String[] args) {
        Manager mgr = new Manager();
        if (args[0].equals("store")) {
	   for (int i = 0; i < 10; i++)
              mgr.createAndStore("nome "+i, "login "+i, "senha "+i);
        }
        HibernateUtil.getSessionFactory().close();
    }
    private void createAndStore(String name, 
		    String login, String passwd) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
	User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPasswd(passwd);
        session.save(user);
        session.getTransaction().commit();
    }
}
