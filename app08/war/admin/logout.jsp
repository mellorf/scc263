<jsp:include page="session.jsp"/>
<%

session.invalidate();
response.sendRedirect("index.jsp");

%>
