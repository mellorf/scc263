package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Para Hibernate
import org.hibernate.Session;
import util.*;

public class User extends HttpServlet {

  private final int INSERT = 0;
  private final int REMOVE = 1;
  private final int UPDATE = 2;

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
      
	int function = 
		Integer.parseInt(request.getParameter("function"));

        PrintWriter out = response.getWriter();

	switch (function) {
		case INSERT:
			sistema.User user = new sistema.User();
			user.setName(request.getParameter("name"));
			user.setLogin(request.getParameter("login"));
			user.setPasswd(request.getParameter("passwd"));

			try {
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();

				session.beginTransaction();
				session.save(user);
				session.getTransaction().commit();

			} catch (Exception e) { e.printStackTrace(); }

			response.sendRedirect("message.jsp?msg=0");
		case REMOVE:
			break;
		case UPDATE:
			break;
	}

  }

  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
      	doGet(request, response);
  }

}
