<%@page import="org.usp.app08.core.*" %>
<jsp:include page="../session.jsp"/>
<jsp:useBean id="news" class="org.usp.app08.core.News" />
<jsp:setProperty name="news" property="*" />
<%

	try {
		news.update();
		response.sendRedirect("../message.jsp?msg=5");
	} catch (Exception e) {
		response.sendRedirect("../message.jsp?msg=6");
		// GET HTTP
	}

%>
