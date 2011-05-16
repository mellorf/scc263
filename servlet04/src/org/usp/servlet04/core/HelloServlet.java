package org.usp.servlet04.core;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class HelloServlet extends HttpServlet {
  public void doGet (HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException
  {
	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();

    	out.println("Via GET: "+request.getParameter("nome"));
    	out.close();
  }

  public void doPost (HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException
  {
	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();

    	out.println("Via POST: "+request.getParameter("nome"));
    	out.close();
  }
}
