<%@page import="org.usp.app08.core.*" %>
<jsp:include page="../session.jsp"/>
<%
	int id = Integer.parseInt(request.getParameter("id"));

	try {
		News news = new News(id);
		news.remove();
		response.sendRedirect("../message.jsp?msg=3");
	} catch (Exception e) {
		response.sendRedirect("../message.jsp?msg=2");
		// GET HTTP
	}

%>
