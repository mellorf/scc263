package org.usp.servlet01.core;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class HelloServlet extends HttpServlet {

  public void doGet (HttpServletRequest request, 
		  HttpServletResponse response)
	  throws ServletException, IOException
  { 
    response.setContentType("text/html"); // Mime Types
    PrintWriter out = response.getWriter();
    Locale locale = request.getLocale(); // Cliente

    out.println("Hello, world!<br>");
    out.println(locale+"<br>");

    out.close();
  }

  public void doPost(HttpServletRequest request, 
		  HttpServletResponse response)
	  throws ServletException, IOException
  {
	doGet(request, response);
  }

}
