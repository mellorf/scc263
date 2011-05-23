package org.usp.dropbox.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.usp.dropbox.db.*;
import org.usp.dropbox.core.*;
import org.usp.dropbox.config.*;

public class UserServlet extends HttpServlet implements Default {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) 
		throws ServletException, java.io.IOException {

	   String targetUrl = null;
	   try {
		// redirecionar de forma forcada
		PageContext pageContext = 
			JspFactory.getDefaultFactory().
			getPageContext(this, request, response,
      			null, true, 8192, true);

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		int type = -1;
		try {
			type =
			 Integer.parseInt(request.getParameter("type"));
		} catch (Exception e) {
			targetUrl = "message.jsp?msg=0";
			response.sendRedirect(targetUrl);
		}

		String email	= request.getParameter("email");
		String password	= request.getParameter("password");
		String name	= request.getParameter("name");
		// freespace, space

		User user = null;
		Database db = null;

		switch (type) {
			case CONFIRMLOGIN:
				user = (User) session.getAttribute("user");
				db = DBManager.getInstance().
						getDatabase();
				if ((user == null) || 
				    (user != null && User.findByEmailPassword(
					db, 
					user.getEmail(),
					user.getPassword()) == null)) {
				    targetUrl = "index.jsp";
				}

				DBManager.getInstance().
						closeDatabase(db);
				if (targetUrl != null) {
					pageContext.forward(targetUrl);
					return;
					//response.sendRedirect(targetUrl);
				}
				break;
			case INSERT: 
				user = new User();
				user.setEmail(email);
				user.setPassword(password);
				user.setName(name);
				user.insert();
				targetUrl = "message.jsp?msg=2";
				break;
			case LOGIN: 
				db = DBManager.getInstance().
						getDatabase();
				user = User.findByEmailPassword(
						db,
						email,
						password);
				if (user == null) {
					targetUrl = 
						"message.jsp?msg=3";
				} else {
					session.setAttribute(
							"user",
							user
							);
				     targetUrl = "dropbox.jsp?iparent="
					     +user.getINode();
				}

				DBManager.getInstance().
						closeDatabase(db);
				break;
			case LOGOUT: 
				session.invalidate();
				targetUrl = "index.jsp";
				break;
			default: 
				targetUrl = "message.jsp?msg=404";
				break;
		}
	   } catch (Exception e) {
		   e.printStackTrace();
		targetUrl = "message.jsp?msg=-1";
	   } finally {
	   	response.sendRedirect(targetUrl);
	   }
	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) 
		throws ServletException, java.io.IOException {
		doGet(request, response);
	}

	// doHead
	// doPut
	// service
}
