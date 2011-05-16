package org.usp.servlet01.core;

import java.io.*;

import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class HelloServlet extends HttpServlet {
  public void doGet (HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException
  {
	response.setContentType("text/html");
	Locale localeBrowser = request.getLocale();
	Locale localeServer = response.getLocale();
    	PrintWriter out = response.getWriter();

	String cpath = request.getContextPath();
	String servletpath = request.getServletPath();
	HttpSession session = request.getSession();

    	out.println("Hello, world!<br>");
    	out.println("Server Locale: "+localeServer+"<br>");
    	out.println("Browser Locale: "+localeBrowser+"<br>");
    	out.println("Context Path: "+cpath+"<br>");
    	out.println("Servlet Path: "+servletpath+"<br>");
    	out.println("Session: "+session+"<br>");
    	out.close();
  }

  public void doPost (HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException
  {
	  doGet(request, response);
  }
}
