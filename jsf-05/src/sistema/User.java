package sistema;

import org.hibernate.Session;
import util.HibernateUtil;
import java.util.*;

public class User {
	// atributos
	private Long id;
	private String name;
	private String login;
	private String passwd;

	public User() {}

	private void setId(Long id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setLogin(String login) { this.login = login; }
	public void setPasswd(String passwd) { this.passwd = passwd; }

	public Long getId() { return id; }
	public String getName() { return name; }
	public String getLogin() { return login; }
	public String getPasswd() { return passwd; }

	public String insert() {
		Session session = 
			HibernateUtil.getSessionFactory().
				getCurrentSession();
		session.beginTransaction();
		session.save(this);
		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

		return "success";
	}

	public String back() {
		return "back";
	}
}
