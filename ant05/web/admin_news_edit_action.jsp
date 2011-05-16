<%@ page import="java.sql.*, org.usp.news.*, java.util.*" %>
<%

	String button = request.getParameter("edit");

	if (button.equals("Editar")) {
		%>
		<jsp:forward page="admin_news_edit2.jsp">
		  <jsp:param name="code" value="<%= request.getParameter("code") %>" />
		</jsp:forward>
		<%
	} else if (button.equals("Remover")) {
		%>
		<jsp:forward page="admin_news_remove.jsp">
		  <jsp:param name="code" value="<%= request.getParameter("code") %>" />
		</jsp:forward>
		<%
	}

%>
