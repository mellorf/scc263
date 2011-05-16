<%@page import="org.usp.app08.db.*, org.usp.app08.core.*" %>
<%
	String hpage = null;
	String email = request.getParameter("email");
	String password = request.getParameter("password");

	Database db = new Database();
	db.connect();
	User user = 
	  User.findByEmailAndPassword(db, email, password);

	if (user != null) {
		session.setAttribute("user", user);
		hpage = "home.jsp";
	} else {
		hpage = "error.jsp?msg=4";
	}

	db.close();

	response.sendRedirect(hpage);
%>
