package sistema;

import org.hibernate.Session;
import java.util.Date;
import util.HibernateUtil;
import java.util.*;

public class Manager {

    public static void main(String[] args) {
        Manager mgr = new Manager();

        if (args[0].equals("store")) {
		for (int i = 1; i <= 10; i++) {
            		mgr.createAndStore("nome "+i, "login "+i, "senha "+i, new Float(100.0));
    			mgr.addContaToUser(new Long(i), new Long(i));
    			mgr.addEmailToUser(new Long(i), "email "+i);
		}
        }

	mgr.findUser(new Long(1));
    	mgr.findContasFromUser(new Long(5));

        HibernateUtil.getSessionFactory().close();
    }

    private void createAndStore(String name, String login, String passwd, Float money) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

	User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPasswd(passwd);

	Conta conta = new Conta();
	conta.setMoney(money);

        System.out.println("Salvando User com ID = "+session.save(user));
        System.out.println("Salvando Conta com ID = "+session.save(conta));
        session.getTransaction().commit();
    }

    private void addContaToUser(Long userId, Long contaId) {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();

	Conta conta = (Conta) session.load(Conta.class, contaId);
	User user = (User) session.load(User.class, userId);
	user.getContas().add(conta);

	session.getTransaction().commit();
    }

    private void findUser(Long userId) {
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	    session.beginTransaction();

	    User user01 = (User) session
		.createQuery("select u from User u where u.id = :uid")
		.setParameter("uid", userId)
		.uniqueResult(); // busca e faz detachment

	    User user02 = (User) session.load(User.class, userId);

	    session.getTransaction().commit();

	    System.out.println(user01.getName()+" "+user01.getLogin()+" "+user01.getPasswd());
	    System.out.println(user02.getName()+" "+user02.getLogin()+" "+user02.getPasswd());
    }

    private void findContasFromUser(Long userId) {
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	    session.beginTransaction();

	    User user01 = (User) session
		    .createQuery("select u from User u left join fetch u.contas where u.id = :uid")
		    .setParameter("uid", userId)
		    .uniqueResult(); // busca e faz detachment

	    session.getTransaction().commit();

	    System.out.println("Contas = "+user01.getContas().size());
	    Iterator i = user01.getContas().iterator();
	    while (i.hasNext()) {
		Conta c = (Conta) i.next();
		System.out.println(user01.getId()+" "+
				c.getId()+" "+c.getMoney());
	    }
    }

    private void addEmailToUser(Long userId, String emailAddress) {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	session.beginTransaction();

	User user = (User) session.load(User.class, userId);
	user.getEmailAddresses().add(emailAddress);

	session.getTransaction().commit();
    }
}
