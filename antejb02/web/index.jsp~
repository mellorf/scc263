<%@page contentType="text/html" pageEncoding="UTF-8" 
	import="javax.naming.*, org.usp.test02.*, javax.rmi.*, java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%

	Properties p = new Properties();
	p.put(Context.INITIAL_CONTEXT_FACTORY, 
	   "org.jboss.iiop.naming.ORBInitialContextFactory");
	p.put(Context.URL_PKG_PREFIXES, 
	   "jboss.naming:org.jnp.interfaces");
	//String partitionName = 
	//	System.getProperty("jboss.partition.name", 
	//	"DefaultPartition");
	p.put("jnp.partitionName", "DefaultPartition");
	//p.put("jnp.partitionName", "192.168.1.100:1100,192.168.1.101:1100");

	Context initialContext = new InitialContext(p);

	System.out.println(initialContext);
	System.out.println(initialContext.getEnvironment());

	    Object remote = initialContext.lookup("exemplo06/CalculatorImpl/remote");
	    out.print("Tipo do objeto: "+remote+"<br>");
	    CalculatorRemote calc = (CalculatorRemote) remote;
	    out.print("Contador: "+calc.count()+"<br>");
%>
    </body>
</html>
