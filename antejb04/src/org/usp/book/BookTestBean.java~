package org.usp.book;

import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BookTestBean implements BookTestBeanLocal, BookTestBeanRemote {

	@PersistenceContext
	EntityManager em;

	public static final String RemoteJNDIName =  BookTestBean.class.getSimpleName() + "/remote";

	public static final String LocalJNDIName =  BookTestBean.class.getSimpleName() + "/local";

	public void test() {
		Book book = new Book(null, "My first bean book", "Sebastian");
		em.persist(book);
		Book book2 = new Book(null, "another book", "Paul");
		em.persist(book2);
		Book book3 = new Book(null, "EJB 3 developer guide, comes soon",
				"Sebastian");
		em.persist(book3);

		System.out.println("list some books");
		List someBooks = em.createQuery("from Book b where b.author=:name")
				.setParameter("name", "Sebastian").getResultList();

		for (Iterator iter = someBooks.iterator(); iter.hasNext();)
		{
			Book element = (Book) iter.next();
			System.out.println(element);
		}

		System.out.println("List all books");
		List allBooks = em.createQuery("from Book").getResultList();

		for (Iterator iter = allBooks.iterator(); iter.hasNext();)
		{
			Book element = (Book) iter.next();
			System.out.println(element);
		}

		System.out.println("delete a book");
		em.remove(book2);

		System.out.println("List all books");
		allBooks = em.createQuery("from Book").getResultList();

		for (Iterator iter = allBooks.iterator(); iter.hasNext();)
		{
			Book element = (Book) iter.next();
			System.out.println(element);
		}
	}
}
