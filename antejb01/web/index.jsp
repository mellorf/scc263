<%@page contentType="text/html" pageEncoding="UTF-8" 
	import="javax.naming.*, org.usp.test01.*, javax.rmi.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%
		// JNDI -> query/search 
	    Context initialContext = new InitialContext();

	    Object remote = initialContext.
	    	lookup("exemplo05/CalculatorImpl/remote");
	    out.print("Tipo do objeto: "+remote+"<br>");
	    CalculatorRemote calc = (CalculatorRemote) remote;
	    out.print("Resultado: "+calc.sum(10,2)+"<br>");
	    out.print("Resultado: "+calc.multiply(10,2));

%>
    </body>
</html>
