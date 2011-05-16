<%@page import="org.usp.app08.core.*" %>
<jsp:include page="../session.jsp"/>
<jsp:useBean id="news" class="org.usp.app08.core.News" />
<jsp:setProperty name="news" property="*" />
<%

	try {
		news.insert();
		response.sendRedirect("../message.jsp?msg=1");
	} catch (Exception e) {
		response.sendRedirect("../message.jsp?msg=0");
		// GET HTTP
	}

%>
