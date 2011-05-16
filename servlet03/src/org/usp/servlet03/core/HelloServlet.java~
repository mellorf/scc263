package org.usp.servlet03.core;

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
    	PrintWriter out = response.getWriter();

	ResourceBundle rb = null;

	rb = ResourceBundle.getBundle(
			"org.usp.servlet03.bundles.messages", 
			localeBrowser);

    	out.println("Mensagem em "+localeBrowser+" -> "+
			rb.getString("MSG"));
    	out.close();
  }

  public void doPost (HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException
  {
	  doGet(request, response);
  }
}
