package sistema;

import org.hibernate.Session;
import java.util.Date;
import util.HibernateUtil;
import java.util.*;

public class Manager {

    public static void main(String[] args) {
        Manager mgr = new Manager();

        if (args[0].equals("store")) {
            	mgr.createAndStore("nome", "login", "senha");
        }

        HibernateUtil.getSessionFactory().close();
    }

    private void createAndStore(String name, String login, String passwd) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

	User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPasswd(passwd);

        System.out.println("Salvando User com ID = "+session.save(user));

        session.getTransaction().commit();
    }
}
