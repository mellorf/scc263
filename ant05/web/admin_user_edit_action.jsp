<%@ page import="java.sql.*, org.usp.news.*, java.util.*" %>
<%

	String button = request.getParameter("edit");

	if (button.equals("Editar")) {
		%>
		<jsp:forward page="admin_user_edit2.jsp">
		  <jsp:param name="login" value="<%= request.getParameter("login") %>" />
		</jsp:forward>
		<%
	} else if (button.equals("Remover")) {
		%>
		<jsp:forward page="admin_user_remove.jsp">
		  <jsp:param name="login" value="<%= request.getParameter("login") %>" />
		</jsp:forward>
		<%
	}

%>
