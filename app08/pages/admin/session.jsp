<%@page import="org.usp.app08.core.*" %>
<%

User user = (User) session.getAttribute("user");
if (user == null) {
	//response.sendRedirect("index.jsp");
%>
	<jsp:forward page="index.jsp" />
<%
}

%>
