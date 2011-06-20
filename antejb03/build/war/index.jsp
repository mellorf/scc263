<%@page contentType="text/html" pageEncoding="UTF-8" 
	import="javax.naming.*, org.usp.test02.*, javax.rmi.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%
	    Context initialContext = new InitialContext();
	    Object remote = initialContext.lookup("exemplo07/CalculatorImpl/remote");
	    out.print("Tipo do objeto: "+remote+"<br>");
	    CalculatorRemote calc = (CalculatorRemote) remote;
	    out.print("Contador: "+calc.count()+"<br>");
%>
    </body>
</html>
