package org.usp.mvc01.core;

import javax.servlet.*;
import javax.servlet.http.*;
import org.usp.mvc01.config.*;
import org.usp.mvc01.core.*;
import org.usp.mvc01.db.*;

public class PersonServlet extends HttpServlet implements Default {

	/*
	public void service(HttpServletRequest request,
			HttpServletResponse response) 
		throws Exception {

	}*/

	public void doGet(HttpServletRequest request,
			HttpServletResponse response) 
		throws ServletException, java.io.IOException {
	
		String targetUrl = null;
		int type = -1;

		try{
			type = Integer.parseInt(
				request.getParameter("type")
				);
		} catch (Exception e) {
			targetUrl = "messages?msg=-1";
			response.sendRedirect(targetUrl);
		}

		String email  = request.getParameter("email");
		String name   = request.getParameter("name");
		String address = request.getParameter("address");
		String phone  = request.getParameter("phone");

		switch (type) {
			case INSERT:
			     try {
				Person p = new Person();
				p.setEmail(email);
				p.setName(name);
				p.setAddress(address);
				p.setPhone(phone);

				p.insert();
				targetUrl = "messages?msg=0";
			     } catch (Exception e) {
				targetUrl = "messages?msg=1";
			     }

			     break;
			case EDIT: 
			     
			     try {
				Person p = new Person(email);
				p.setName(name);
				p.setAddress(address);
				p.setPhone(phone);
				p.update();
				targetUrl = "messages?msg=2";
			     } catch (Exception e) {
				targetUrl = "messages?msg=3";
			     }
			     
			     break;
			case REMOVE: 
			     
			     try {
				Person p = new Person(email);
				p.remove();
				targetUrl = "messages?msg=4";
			     } catch (Exception e) {
				targetUrl = "messages?msg=5";
			     }
			     
			     break;
			default: break;
		}

		response.sendRedirect(targetUrl);
	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) 
		throws ServletException, java.io.IOException {
		doGet(request, response);
	}
}
